package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class MenuxperfilPK implements Serializable {

    private int idperfil;

    private int idmenu;

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuxperfilPK that = (MenuxperfilPK) o;
        return idperfil == that.idperfil && idmenu == that.idmenu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idperfil, idmenu);
    }
}
