package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;

import java.util.Objects;

//@Entity
public class Menu {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "idmenu")
    private int idmenu;
    private String url;
    private String nombre;

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return idmenu == menu.idmenu && Objects.equals(url, menu.url) && Objects.equals(nombre, menu.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmenu, url, nombre);
    }
}
