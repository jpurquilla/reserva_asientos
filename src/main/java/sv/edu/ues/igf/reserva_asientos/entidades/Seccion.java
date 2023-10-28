/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
@Entity
public class Seccion implements Serializable {
    
    @EmbeddedId
    private SeccionPK seccionPK;
    private String nombre;
    private BigDecimal precio;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="idevento", referencedColumnName="idevento"),
        @JoinColumn(name="idseccion", referencedColumnName="idseccion"),
    })
    private List<Localidad> localidades = new ArrayList<>();
    
    public Seccion() {
    }

    public Seccion(SeccionPK seccionPK, String nombre, BigDecimal precio) {
        this.seccionPK = seccionPK;
        this.nombre = nombre;
        this.precio = precio;
    }

    public SeccionPK getSeccionPK() {
        return seccionPK;
    }

    public void setSeccionPK(SeccionPK seccionPK) {
        this.seccionPK = seccionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.seccionPK);
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.precio);
        hash = 11 * hash + Objects.hashCode(this.localidades);
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
        final Seccion other = (Seccion) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.seccionPK, other.seccionPK)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        return Objects.equals(this.localidades, other.localidades);
    }

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seccion{");
        sb.append("seccionPK=").append(seccionPK);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", localidades=").append(localidades);
        sb.append('}');
        return sb.toString();
    }


    
}
