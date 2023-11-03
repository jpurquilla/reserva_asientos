/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Leo
 */
@Embeddable
public class ReservadetallePK implements Serializable {
    
    private int idreserva;
    private String codigo;
    private int idevento;
    private int idseccion;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        hash = 29 * hash + this.idreserva;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final ReservadetallePK other = (ReservadetallePK) obj;
        if (this.idreserva != other.idreserva) {
            return false;
        }
        if (this.idevento != other.idevento) {
            return false;
        }
        if (this.idseccion != other.idseccion) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "ReservadetallePK{" + "idreserva=" + idreserva + ", codigo=" + codigo + ", idevento=" + idevento + ", idseccion=" + idseccion + '}';
    }
    
}
