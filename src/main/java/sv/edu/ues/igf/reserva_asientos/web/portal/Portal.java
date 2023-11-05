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
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.repository.EventoRepository;
import sv.edu.ues.igf.reserva_asientos.web.configuracion.SessionBean;

/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class Portal implements Serializable {

    @Inject
    EventoRepository eventoRepository;
    
    @Inject
    private SessionBean sessionBean;
    
    private List<Evento> eventos;
    private List<String> images = List.of("demo-image.avif", "demo-image.avif", "demo-image.avif");

    @PostConstruct
    public void init(){
        eventos = eventoRepository.buscarEventos();
        eventos.forEach(e -> {
            //images.add(new DefaultStreamedContent(new ByteArrayInputStream(e.getFoto())));
        });
        System.out.println(eventos);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTimeFormatted(LocalTime time){
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return time.format(dtFormatter);
    }
    
    public String goToReserva(Evento evento){
//        if(sessionBean == null || sessionBean.getCodusr() == null || sessionBean.getCodusr().equals("")) {
//            return "/seguridad/login.xhtml?faces-redirect=true";
//        }
        if(!sessionBean.isIsLogged()) {
             return "/seguridad/login.xhtml?faces-redirect=true";
        }
            
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().put("evento", evento);
        return "reserva.xhtml?faces-redirect=true&idevento=" + evento.getIdevento();
    }
}
