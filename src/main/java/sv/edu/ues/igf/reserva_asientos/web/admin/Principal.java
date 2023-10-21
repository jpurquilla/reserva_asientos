package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.web.configuracion.SessionBean;

import java.io.Serializable;

@SessionScoped
@Named
public class Principal  implements Serializable {
    @Inject
    private SessionBean sessionBean;



    public SessionBean getSessionBean() {
        return sessionBean;
    }


    @PostConstruct
    public void init() {

        System.out.println("No esta entrando aqui o si?");
        System.out.println("Si estamos en el init del bean principal");
        System.out.println(sessionBean.getListaMenu());
    }

}
