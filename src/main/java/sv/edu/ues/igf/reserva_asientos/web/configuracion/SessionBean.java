package sv.edu.ues.igf.reserva_asientos.web.configuracion;

import jakarta.enterprise.context.SessionScoped;
import sv.edu.ues.igf.reserva_asientos.entidades.Menu;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SessionScoped
public class SessionBean implements Serializable {
    private String nombreUsuario;
    private String codusr;
    private Integer idpersona;
    private List<Menu> listaMenu;




    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCodusr() {
        return codusr;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public List<Menu> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<Menu> listaMenu) {
        this.listaMenu = listaMenu;
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
                ", listaMenu=" + listaMenu +
                '}';
    }
}
