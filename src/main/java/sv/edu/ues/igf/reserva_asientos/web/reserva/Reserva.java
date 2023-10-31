/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.reserva;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
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
    private String numCuenta = null;
    private String vencCuenta = null;
    private String ccvCuenta = null;
    
    @PostConstruct
    public void init(){
        subtotal = BigDecimal.ZERO;
        localidadesSeleccionadas = new ArrayList<>();
        secciones = seccionRepository.getSeccionesByEvento(1);
        System.out.println("welcome -> " + secciones);            
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

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getVencCuenta() {
        return vencCuenta;
    }

    public void setVencCuenta(String vencCuenta) {
        this.vencCuenta = vencCuenta;
    }

    public String getCcvCuenta() {
        return ccvCuenta;
    }

    public void setCcvCuenta(String ccvCuenta) {
        this.ccvCuenta = ccvCuenta;
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
    
    public void confirmarPago(){
        if(numCuenta == null || ccvCuenta == null || vencCuenta == null){
            return;
        }
        System.out.println("Pago realizado con éxito");
    }
}
