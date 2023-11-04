/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Leo
 */
@Embeddable
public class SeccionPK implements Serializable {
    
    private Integer idevento;
    private Integer idseccion;

    public SeccionPK() {
    }

    public SeccionPK(Integer idevento, Integer idseccion) {
        this.idevento = idevento;
        this.idseccion = idseccion;
    }
    
    public SeccionPK(Integer idseccion) {
        this.idseccion = idseccion;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Integer getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(Integer idseccion) {
        this.idseccion = idseccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idevento;
        hash = 29 * hash + this.idseccion;
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
        final SeccionPK other = (SeccionPK) obj;
        if (this.idevento != other.idevento) {
            return false;
        }
        return this.idseccion == other.idseccion;
    }
    
    
    
}
