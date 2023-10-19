package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.web.SessionBean;

import java.io.Serializable;

@SessionScoped
@Named
public class Principal  implements Serializable {
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }


    @PostConstruct
    public void init() {
        System.out.println(sessionBean);
    }

}
