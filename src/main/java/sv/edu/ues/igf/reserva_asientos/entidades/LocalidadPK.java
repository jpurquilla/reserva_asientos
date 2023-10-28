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
public class LocalidadPK implements Serializable{
    
    private String codigo;
    private int idevento;
    private int idseccion;

    public LocalidadPK() {
    }

    public LocalidadPK(String codigo, int idevento, int idseccion) {
        this.codigo = codigo;
        this.idevento = idevento;
        this.idseccion = idseccion;
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
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        hash = 59 * hash + this.idevento;
        hash = 59 * hash + this.idseccion;
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
        final LocalidadPK other = (LocalidadPK) obj;
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
        StringBuilder sb = new StringBuilder();
        sb.append("LocalidadPK{");
        sb.append("codigo=").append(codigo);
        sb.append(", idevento=").append(idevento);
        sb.append(", idseccion=").append(idseccion);
        sb.append('}');
        return sb.toString();
    }
        
}
