
package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.primefaces.PrimeFaces;
import sv.edu.ues.igf.reserva_asientos.entidades.Perfil;
import sv.edu.ues.igf.reserva_asientos.entidades.Persona;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;
import sv.edu.ues.igf.reserva_asientos.repository.PerfilRepository;
import sv.edu.ues.igf.reserva_asientos.repository.PersonaRepository;
import sv.edu.ues.igf.reserva_asientos.repository.UsuarioRepository;

@Named
@SessionScoped
public class RegistroBean implements Serializable{
    @Inject
    PersonaRepository personaRepository;
    
    @Inject
    PerfilRepository perfilRepository;
    
    @Inject
    UsuarioRepository usuarioRepository;
    
    private Integer idPersona = null;
    private String nombres;
    private String apellidos;
    private String dui;
    private String email;
    private String telefono;
    private String codusr;
    private String password;
    private List <Persona> lstPersonas = new ArrayList<>();
    private List <Perfil> lstPerfiles;
    private List <SelectItem> lstPerfilItem;
    private Integer perfilSel;
    

    public List<Perfil> getLstPerfiles() {
        return lstPerfiles;
    }

    public Integer getPerfilSel() {
        return perfilSel;
    }

    public void setPerfilSel(Integer perfilSel) {
        this.perfilSel = perfilSel;
    }

    public void setLstPerfiles(List<Perfil> lstPerfiles) {
        this.lstPerfiles = lstPerfiles;
    }
    
    

    public List<SelectItem> getLstPerfilItem() {
        return lstPerfilItem;
    }

    public void setLstPerfilItem(List<SelectItem> lstPerfilItem) {
        this.lstPerfilItem = lstPerfilItem;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
    @PostConstruct
    public void init() {
        limpiar();
        lstPersonas = personaRepository.listarPersonas();
        lstPerfiles = perfilRepository.listarPerfiles();
        lstPerfilItem = lstPerfiles.stream().map(p -> {
            return new SelectItem(p.getIdperfil(), p.getDescripcion());
        }).toList();
        
    }
    
    
    @Transactional
    public void guardarRegistro(ActionEvent ae) {
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        if(!validar()) return;
        
        if(idPersona != null) {
            persona = personaRepository.buscarPersona(idPersona);
            usuario = usuarioRepository.buscarUsuarioPorIdPersona(idPersona);
        } else {
            usuario.setCodusr(codusr);
            usuario.setFechacrea(LocalDateTime.now());
        }
        persona.setNombres(nombres);
        persona.setApellidos(apellidos);
        persona.setDui(dui);
        persona.setEmail(email);
        persona.setTelefono(telefono);
        
        persona = personaRepository.guardarPersona(persona);
        
        Perfil perfil =lstPerfiles.stream().filter(p -> p.getIdperfil() == perfilSel).findAny().get();
        usuario.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        usuario.setIdpersona(persona.getIdpersona());
        usuario.setIdperfil(perfil.getIdperfil());
        usuarioRepository.guardarUsuario(usuario);
        lstPersonas.clear();
        lstPersonas = personaRepository.listarPersonas();
        
        
       
        limpiar();
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Guardado con exito");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        
        PrimeFaces.current().ajax().update( "formLista:tblUsuarios");
        PrimeFaces.current().executeScript("PF('personaDialog').hide()");
       
        
    }
    
    public boolean validar() {
        boolean valido = true;
        StringBuilder mensajes = new StringBuilder();
        if (!email.isBlank() && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            
                mensajes.append("- El email no tiene formato correcto \n\n");
                valido = false;
        }
        if(nombres.isBlank() || apellidos.isBlank() || dui.isBlank() 
                || email.isBlank() || telefono.isBlank() || codusr.isBlank() 
                || perfilSel == 0 || password.isBlank()) {
            valido = false;
            mensajes.append("- Debe completar todos los campos");
        }
        if(valido && idPersona == null) {
            Usuario usuarioAVerificar = usuarioRepository.listarUsuarios(codusr);
            if(usuarioAVerificar != null) {
                valido = false;
                mensajes.append("- Ese codigo de usuario ya existe");
            }
        }
        
        if(!valido) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "Info:", mensajes.toString());
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }
        return valido; 
    }
    
    public void limpiar() {
        idPersona = null;
        nombres = "";
        apellidos = "";
        dui = "";
        email = "";
        telefono = "";
        codusr = "";
        password = "";
        perfilSel = 0;
    }
    
    @Transactional
    public void eliminarPersona (Persona persona) {
       personaRepository.eliminarPersona(persona.getIdpersona());
       lstPersonas.remove(persona);
    }
    
    public void seleccionarPersona (Persona persona) {
        idPersona = persona.getIdpersona();
        nombres = persona.getNombres();
        apellidos = persona.getApellidos();
        dui = persona.getDui();
        email = persona.getEmail();
        telefono = persona.getTelefono(); 
        Usuario usuario = usuarioRepository.buscarUsuarioPorIdPersona(idPersona);
        codusr = usuario.getCodusr();
        perfilSel = usuario.getIdperfil();
        
    }
    
    
}
