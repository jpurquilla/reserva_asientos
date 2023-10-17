package sv.edu.ues.igf.reserva_asientos.web.seguridad;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;
import sv.edu.ues.igf.reserva_asientos.repository.UsuarioRepository;

import java.util.logging.Logger;

@Named
@RequestScoped
public class Login {
    @Inject
    private UsuarioRepository usuarioRepository;

    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    private String codusr;
    private String password;

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

    public String loginAction() {
        LOGGER.info("El usuario es " + codusr + " password " + password);
        System.out.println("Aqui estamos con la info del usuario "+ codusr + " password " + password);
        Usuario usuario = usuarioRepository.buscarUsuario(codusr);
        System.out.println("El usuario es: ");
        System.out.println(usuario.toString());


        return usuario.getIdperfil() == 10 ? "/admin/principal.xhtml" : "/portal/principal.xhtml";

    }
}
