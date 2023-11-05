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
    private Integer idperfil;
    private boolean isLogged = false;

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
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

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 79 * hash + Objects.hashCode(this.codusr);
        hash = 79 * hash + Objects.hashCode(this.idpersona);
        hash = 79 * hash + Objects.hashCode(this.listaMenu);
        hash = 79 * hash + Objects.hashCode(this.idperfil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SessionBean other = (SessionBean) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.codusr, other.codusr)) {
            return false;
        }
        if (!Objects.equals(this.idpersona, other.idpersona)) {
            return false;
        }
        if (!Objects.equals(this.listaMenu, other.listaMenu)) {
            return false;
        }
        return Objects.equals(this.idperfil, other.idperfil);
    }

    @Override
    public String toString() {
        return "SessionBean{" + "nombreUsuario=" + nombreUsuario + ", codusr=" + codusr + ", idpersona=" + idpersona + ", listaMenu=" + listaMenu + ", idperfil=" + idperfil + '}';
    }
}
