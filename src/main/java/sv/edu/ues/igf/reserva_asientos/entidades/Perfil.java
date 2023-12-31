package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Perfil {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idperfil;
    private String descripcion;
//    @OneToMany(ma
    @ManyToMany
    @JoinTable(
            name = "menuxperfil",
            joinColumns = @JoinColumn(name = "idperfil"),
            inverseJoinColumns = @JoinColumn(name = "idmenu")
    )
    private List<Menu> menus;

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return idperfil == perfil.idperfil && Objects.equals(descripcion, perfil.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idperfil, descripcion);
    }

//    public List<Menuxperfil> getMenuxperfilsByIdperfil() {
//        return menuxperfilsByIdperfil;
//    }
//
//    public void setMenuxperfilsByIdperfil(List<Menuxperfil> menuxperfilsByIdperfil) {
//        this.menuxperfilsByIdperfil = menuxperfilsByIdperfil;
//    }
}
