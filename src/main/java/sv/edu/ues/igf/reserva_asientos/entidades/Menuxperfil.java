package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(MenuxperfilPK.class)
public class Menuxperfil {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idperfil")
    private int idperfil;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmenu")
    private int idmenu;
    @ManyToOne
    @JoinColumn(name = "idmenu", referencedColumnName = "idmenu", nullable = false)
    private Menu menuByIdmenu;

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
        Menuxperfil that = (Menuxperfil) o;
        return idperfil == that.idperfil && idmenu == that.idmenu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idperfil, idmenu);
    }

    public Menu getMenuByIdmenu() {
        return menuByIdmenu;
    }

    public void setMenuByIdmenu(Menu menuByIdmenu) {
        this.menuByIdmenu = menuByIdmenu;
    }
}
