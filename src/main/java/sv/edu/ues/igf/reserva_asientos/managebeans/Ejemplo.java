package sv.edu.ues.igf.reserva_asientos.managebeans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("ejemplo")
@ViewScoped
public class Ejemplo implements Serializable{

    private String saludo = "Hola " ;

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }



    @PostConstruct
    public void init() {
        saludo = saludo + "Jp";
        System.out.println("entro al inicio de la clase ");
    }




}
