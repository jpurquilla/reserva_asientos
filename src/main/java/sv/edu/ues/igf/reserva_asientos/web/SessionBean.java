package sv.edu.ues.igf.reserva_asientos.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.entidades.Menu;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SessionScoped
@Named
public class SessionBean implements Serializable {
    private String nombreUsuario;
    private String codusr;
    private Integer idpersona;
    private List<Menu> listaMenu;


    public SessionBean(){}
    public SessionBean(String nombreUsuario, String codusr, Integer idpersona,List<Menu>listaMenu) {
        this.nombreUsuario = nombreUsuario;
        this.codusr = codusr;
        this.idpersona = idpersona;
        this.listaMenu = listaMenu;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCodusr() {
        return codusr;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionBean that = (SessionBean) o;
        return Objects.equals(nombreUsuario, that.nombreUsuario) && Objects.equals(codusr, that.codusr) && Objects.equals(idpersona, that.idpersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario, codusr, idpersona);
    }

    @Override
    public String toString() {
        return "SessionBean{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", codusr='" + codusr + '\'' +
                ", idpersona=" + idpersona +
                '}';
    }
}
