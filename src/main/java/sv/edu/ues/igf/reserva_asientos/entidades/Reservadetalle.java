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
public class Reservadetalle implements Serializable {
    
    @EmbeddedId
    private ReservadetallePK reservadetallePK;

    public ReservadetallePK getReservadetallePK() {
        return reservadetallePK;
    }

    public void setReservadetallePK(ReservadetallePK reservadetallePK) {
        this.reservadetallePK = reservadetallePK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.reservadetallePK);
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
        final Reservadetalle other = (Reservadetalle) obj;
        return Objects.equals(this.reservadetallePK, other.reservadetallePK);
    }

    @Override
    public String toString() {
        return "Reservadetalle{" + "reservadetallePK=" + reservadetallePK + '}';
    }    
    
}
