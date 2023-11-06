package sv.edu.ues.igf.reserva_asientos.web.seguridad;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;
import sv.edu.ues.igf.reserva_asientos.repository.UsuarioRepository;
import sv.edu.ues.igf.reserva_asientos.web.configuracion.SessionBean;

import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

@Named
@SessionScoped
public class Login implements Serializable{
    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    SessionBean sesion;
    
    

    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    private String codusr;
    private String password;
    
    private boolean isLogged = false;

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

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String loginAction() {
       
        Usuario usuario = usuarioRepository.listarUsuarios(codusr);
        
        if(usuario == null) {
            return "";
        }
        if(!BCrypt.checkpw(password, usuario.getPassword())) {
            return "ususario o password incorrecto";
        }
        
        
        //sesion.setNombreUsuario(usuario.getPersona().getNombres());
        sesion.setCodusr(usuario.getCodusr());
        sesion.setIdpersona(usuario.getIdpersona());
        sesion.setIdperfil(usuario.getIdperfil());
        sesion.setIsLogged(true);
        isLogged = true;


       
        return usuario.getIdperfil() == 10 ? "/admin/principal.xhtml" : "/portal/principal.xhtml";

    }
    
    public void logout() {
        try {
            sesion.setCodusr("");
            sesion.setIdperfil(null);
            sesion.setNombreUsuario("");
            sesion.setIdpersona(null);
            sesion.setIsLogged(false);
            isLogged = false;
            
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/portal/principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
