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
    
    private int idevento;
    private int idseccion;

    public SeccionPK() {
    }

    public SeccionPK(int idevento, int idseccion) {
        this.idevento = idevento;
        this.idseccion = idseccion;
    }

    public int getIdevento() {
        return idevento;
    }

    public void setIdevento(int idevento) {
        this.idevento = idevento;
    }

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
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
