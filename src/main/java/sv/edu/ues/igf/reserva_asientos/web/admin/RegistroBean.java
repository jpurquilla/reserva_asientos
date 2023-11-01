
package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import sv.edu.ues.igf.reserva_asientos.entidades.Perfil;
import sv.edu.ues.igf.reserva_asientos.entidades.Persona;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;
import sv.edu.ues.igf.reserva_asientos.repository.PerfilRepository;
import sv.edu.ues.igf.reserva_asientos.repository.PersonaRepository;

@Named
@RequestScoped
public class RegistroBean {
    @Inject
    PersonaRepository personaRepository;
    
    @Inject
    PerfilRepository perfilRepository;
    
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
        Persona persona = new Persona(nombres, apellidos, dui, email, telefono);
        personaRepository.guardarPersona(persona);
        //Usuario usuario = new Usuario(codusr, password, persona, null);
        //usuario
        
        lstPersonas.add(persona);
        limpiar();
        
        PrimeFaces.current().ajax().update( "formLista:tblUsuarios");
        PrimeFaces.current().executeScript("PF('personaDialog').hide()");
       
        
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
    }
    
    @Transactional
    public void eliminarPersona (Persona persona) {
        Usuario usuario = persona.getUsuario();
        
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
    }
    
    
}
