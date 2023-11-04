/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;
import sv.edu.ues.igf.reserva_asientos.entidades.Seccion;
import sv.edu.ues.igf.reserva_asientos.repository.EventoRepository;
import sv.edu.ues.igf.reserva_asientos.repository.LocalidadRepository;
import sv.edu.ues.igf.reserva_asientos.repository.ReservaRepository;
import sv.edu.ues.igf.reserva_asientos.repository.SeccionRepository;

/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class ReservaBean implements Serializable {

    @Inject
    SeccionRepository seccionRepository;

    @Inject
    ReservaRepository reservaRepository;

    @Inject
    LocalidadRepository localidadRepository;
    
    @Inject
    EventoRepository eventoRepository;
    

    private List<Seccion> secciones;
    private List<Localidad> localidadesSeleccionadas;
    private BigDecimal subtotal;
    private Integer cantidadaReservar;
    private Evento evento;
    private boolean guardarReserva;
    private Reserva reserva;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        evento = eventoRepository.buscarEventoById(Integer.parseInt(params.get("idevento")));
        if(evento == null) {
            try {
               
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect(externalContext.getRequestContextPath() + "/portal/principal.xhtml");
               
                return;
            } catch (IOException ex) {
                Logger.getLogger(ReservaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        subtotal = BigDecimal.ZERO;
        guardarReserva = true;
        if (guardarReserva) {
            reserva = reservaRepository.guardarReserva(guardarReserva());
            guardarReserva = false;
        }
        localidadesSeleccionadas = new ArrayList<>();
        secciones = seccionRepository.getSeccionesByEvento(evento.getIdevento());
        secciones.forEach(s -> {
            Collections.sort(s.getLocalidades(), (a, b) -> a.getLocalidadPK().getCodigo().compareTo(b.getLocalidadPK().getCodigo()));
        });
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

    public Reserva guardarReserva() {
        Reserva reserva = new Reserva();
        reserva.setEstado(10);
        reserva.setTotal(subtotal);
        reserva.setIdpersona(1);
        reserva.setFecha(LocalDate.now());
        return reserva;
    }

    public void changeStatus(Localidad localidad) {
        if (localidadesSeleccionadas.size() >= cantidadaReservar && !localidadesSeleccionadas.contains(localidad)) {
            return;
        }
        if (localidad.getEstado() == 40 || localidad.getEstado() == 30) {
            return;
        }
        Seccion seccion = secciones.stream().filter(s -> s.getSeccionPK().getIdseccion() == localidad.getLocalidadPK().getIdseccion()).toList().get(0);
        System.out.println("localidad ------------------> " + localidad);
        if (localidad.getEstado() == 20) {
            localidadesSeleccionadas.remove(localidad);
            subtotal = subtotal.subtract(seccion.getPrecio());
            localidad.setEstado(10);
            localidadRepository.actualizarLocalidad(localidad);
        } 
        else if (localidad.getEstado() == 10) {
            localidadesSeleccionadas.add(localidad);
            subtotal = subtotal.add(seccion.getPrecio());
            localidad.setEstado(30);
            localidadRepository.actualizarLocalidad(localidad);
            localidad.setEstado(20);
        }
        System.out.println("************************************** " + localidadesSeleccionadas);
    }

    public BigDecimal getPrecioSeccion(Localidad localidad) {
        return secciones.stream().filter(s -> s.getSeccionPK().getIdseccion() == localidad.getLocalidadPK().getIdseccion()).toList().get(0).getPrecio();
    }

    public void reestablecerSelecciones() {
        secciones.forEach(s -> {
            s.getLocalidades().stream().filter(l -> l.getEstado() == 20).forEach(l -> {
                l.setEstado(10);
                localidadRepository.actualizarLocalidad(l);
            });
        });
        localidadesSeleccionadas.clear();
        subtotal = BigDecimal.ZERO;
    }

    public String confirmarPago() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("subtotal", subtotal);
        flash.put("evento", evento);
        flash.put("reserva", reserva);
        flash.put("localidadesSeleccionadas", localidadesSeleccionadas);
        return "pagosentradas.xhtml?faces-redirect=true&idevento="+evento.getIdevento()+"&idreserva="+reserva.getIdreserva();
    }
    
    public void pollLocalidades(){
        secciones = seccionRepository.getSeccionesByEvento(evento.getIdevento());
        secciones.forEach(s -> {
            Collections.sort(s.getLocalidades(), (a, b) -> a.getLocalidadPK().getCodigo().compareTo(b.getLocalidadPK().getCodigo()));
            s.getLocalidades().stream().filter(l -> localidadesSeleccionadas.stream().map(p -> p.getLocalidadPK()).toList().contains(l.getLocalidadPK())).toList().forEach(l -> l.setEstado(20));
        });
        System.out.println(localidadesSeleccionadas);
    }
    
    public String redirectTimeout(){
        return "principal.xhtml?faces-redirect=true";
    }
}
