/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Leo
 */
@Entity
public class Localidad implements Serializable {
    
    @EmbeddedId
    private LocalidadPK localidadPK;
    private Integer estado;

    public Localidad() {
    }

    public Localidad(LocalidadPK localidadPK, int estado) {
        this.localidadPK = localidadPK;
        this.estado = estado;
    }
    
    public Localidad (String codigo, Integer idseccion,Integer estado) {
        this.localidadPK = new LocalidadPK(codigo, idseccion);
        this.estado = estado;
    }

    public LocalidadPK getLocalidadPK() {
        return localidadPK;
    }

    public void setLocalidadPK(LocalidadPK localidadPK) {
        this.localidadPK = localidadPK;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.localidadPK);
        hash = 97 * hash + this.estado;
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
        final Localidad other = (Localidad) obj;
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.localidadPK, other.localidadPK);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Localidad{");
        sb.append("localidadPK=").append(localidadPK);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
