/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.entidades;

import java.math.BigDecimal;
import java.util.Objects;
/**
 *
 * @author Leo
 */
public class Localidad {
    
    private int id;
    private int status;
    private BigDecimal precio;

    public Localidad() {
    }
    
    public Localidad(int id, int status, BigDecimal precio) {
        this.id = id;
        this.status = status;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.status;
        hash = 31 * hash + Objects.hashCode(this.precio);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return Objects.equals(this.precio, other.precio);
    }

    @Override
    public String toString() {
        return "Localidad{" + "id=" + id + ", status=" + status + ", precio=" + precio + '}';
    }
    
    
}
