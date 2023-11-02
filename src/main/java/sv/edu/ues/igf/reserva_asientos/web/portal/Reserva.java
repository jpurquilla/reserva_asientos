/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DialogFrameworkOptions;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Seccion;
import sv.edu.ues.igf.reserva_asientos.repository.LocalidadRepository;
import sv.edu.ues.igf.reserva_asientos.repository.SeccionRepository;
/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class Reserva implements Serializable {
        
    @Inject
    SeccionRepository seccionRepository;
    
    private List<Seccion> secciones;
    private List<Localidad> localidadesSeleccionadas;
    private BigDecimal subtotal;
    private Integer cantidadaReservar;
    private Evento evento;
    
    @PostConstruct
    public void init(){
        subtotal = BigDecimal.ZERO;
        localidadesSeleccionadas = new ArrayList<>();
        secciones = seccionRepository.getSeccionesByEvento(1);
        evento = (Evento) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("evento");
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
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

    public Integer getCantidadaReservar() {
        return cantidadaReservar;
    }

    public void setCantidadaReservar(Integer cantidadaReservar) {
        this.cantidadaReservar = cantidadaReservar;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
          
    public void changeStatus(Localidad localidad){
        if(localidadesSeleccionadas.size() >= cantidadaReservar && !localidadesSeleccionadas.contains(localidad)){
            return;
        }
        if(localidad.getEstado() == 30){
            return;
        }
        Seccion seccion = secciones.stream().filter(s -> s.getSeccionPK().getIdseccion() == localidad.getLocalidadPK().getIdseccion()).toList().get(0);
        seccion.getLocalidades().stream().filter(l -> l.getLocalidadPK() == localidad.getLocalidadPK()).toList().get(0).setEstado(localidad.getEstado()== 20 ? 10 : 20);
        if(localidad.getEstado() != 20){
            localidadesSeleccionadas.remove(localidad);
            subtotal = subtotal.subtract(seccion.getPrecio());
        }else{
            localidadesSeleccionadas.add(localidad);
            subtotal = subtotal.add(seccion.getPrecio());
        }
        //subtotal = localidadesSeleccionadas.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(seccion.getPrecio()), BigDecimal::add);
        System.out.println("new -> " + seccion.getLocalidades());
        System.out.println("subtotal -> " + subtotal);
    }
    
    public BigDecimal getPrecioSeccion(Localidad localidad){
        return secciones.stream().filter(s -> s.getSeccionPK().getIdseccion() == localidad.getLocalidadPK().getIdseccion()).toList().get(0).getPrecio();
    }
    
    public void reestablecerSelecciones(){
        secciones.forEach(s -> {
            s.getLocalidades().stream().filter(l -> l.getEstado() != 30).forEach(l -> {
                l.setEstado(10);
            });
        });
        localidadesSeleccionadas.clear();
        subtotal = BigDecimal.ZERO;
    }
    
    public String confirmarPago(){
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("subtotal", subtotal);
        flash.put("cantidadaReservar", cantidadaReservar);
        return "pagosentradas.xhtml?faces-redirect=true";
    }
}
