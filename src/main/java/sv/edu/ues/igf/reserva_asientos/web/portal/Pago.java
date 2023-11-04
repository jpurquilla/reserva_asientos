/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;
import sv.edu.ues.igf.reserva_asientos.entidades.Reservadetalle;
import sv.edu.ues.igf.reserva_asientos.entidades.ReservadetallePK;
import sv.edu.ues.igf.reserva_asientos.repository.EventoRepository;
import sv.edu.ues.igf.reserva_asientos.repository.LocalidadRepository;
import sv.edu.ues.igf.reserva_asientos.repository.ReservaRepository;
import sv.edu.ues.igf.reserva_asientos.repository.ReservadetalleRepository;
 /*
 * @author Leo
 */
@Named
@ViewScoped
public class Pago implements Serializable{
    
    @Inject
    LocalidadRepository localidadRepository;
    
    @Inject     
    ReservadetalleRepository reservadetalleRepository;
    
    @Inject
    ReservaRepository reservaRepository;  
    
    @Inject
    EventoRepository eventoRepository;        
    
    List<Localidad> localidadesSeleccionadas;
    BigDecimal subtotal;
    Evento evento;
    Reserva reserva;
    
    @PostConstruct
    public void init(){
        subtotal = (BigDecimal)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("subtotal");
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        evento = eventoRepository.buscarEventoById(Integer.parseInt(params.get("idevento")));
        reserva = reservaRepository.buscarEventoById(Integer.parseInt(params.get("idreserva")));
        if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get("localidadesSeleccionadas") instanceof Collection){
            localidadesSeleccionadas = new ArrayList<>((Collection<Localidad>) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("localidadesSeleccionadas"));
        }
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public String confirmarPago(){
        if(localidadesSeleccionadas == null){
            return "principal.xhtml?faces-redirect=true";
        }
        List<Reservadetalle> reservaDetalles = new ArrayList<>();
        localidadesSeleccionadas.forEach(l -> {
            ReservadetallePK pk = new ReservadetallePK();
            pk.setIdreserva(reserva.getIdreserva());
            pk.setIdevento(l.getLocalidadPK().getIdevento());
            pk.setIdseccion(l.getLocalidadPK().getIdseccion());
            pk.setCodigo(l.getLocalidadPK().getCodigo());
            Reservadetalle reservadetalle = new Reservadetalle();
            reservadetalle.setReservadetallePK(pk);
            reservaDetalles.add(reservadetalle);
            l.setEstado(40);
            reservadetalleRepository.guardarReservaDetalle(reservadetalle);
            localidadRepository.actualizarLocalidad(l);
        });
        reserva.setEstado(20);
        reserva.setTotal(subtotal);
        reservaRepository.actualizarReserva(reserva);
        return "principal.xhtml?faces-redirect=true";
    }
    
    public String cancelarPago(){
        if(localidadesSeleccionadas == null){
            return "principal.xhtml?faces-redirect=true";
        }
        localidadesSeleccionadas.forEach(l -> {
            l.setEstado(10);
            localidadRepository.actualizarLocalidad(l);
        });
        reserva.setEstado(30);
        reservaRepository.actualizarReserva(reserva);
        return "principal.xhtml?faces-redirect=true";
    }
    
}
