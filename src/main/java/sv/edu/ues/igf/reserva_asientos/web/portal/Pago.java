/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;
 /*
 * @author Leo
 */
@Named
@ViewScoped
public class Pago implements Serializable{
    
    List<Localidad> localidadesSeleccionadas;
    BigDecimal subtotal;
    
    @PostConstruct
    public void init(){
        subtotal = (BigDecimal)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("subtotal");
    }

    public List<Localidad> getLocalidadesSeleccionadas() {
        return localidadesSeleccionadas;
    }

    public void setLocalidadesSeleccionadas(List<Localidad> localidadesSeleccionadas) {
        this.localidadesSeleccionadas = localidadesSeleccionadas;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
