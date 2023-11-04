package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.primefaces.event.FileUploadEvent;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import sv.edu.ues.igf.reserva_asientos.entidades.Seccion;
import sv.edu.ues.igf.reserva_asientos.repository.EventoRepository;
import sv.edu.ues.igf.reserva_asientos.repository.LocalidadRepository;
import sv.edu.ues.igf.reserva_asientos.repository.SeccionRepository;

@Named
@SessionScoped
public class Eventos implements Serializable {

    @Inject
    EventoRepository eventoRepository;
    
    @Inject
    LocalidadRepository localidadRepository;
    
    @Inject
    SeccionRepository seccionRepository;

    private Evento evento;
    private LocalDate fechaMinima = LocalDate.now();
    private LocalTime hora;
    private List<Seccion> lstSecciones = new ArrayList<>();
    private List<Localidad> lstLocalidades = new ArrayList<>();
    private List<Evento> lstEventos = new ArrayList<>();

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDate getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(LocalDate fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public List<Seccion> getLstSecciones() {
        return lstSecciones;
    }

    public void setLstSecciones(List<Seccion> lstSecciones) {
        this.lstSecciones = lstSecciones;
    }

    public List<Evento> getLstEventos() {
        return lstEventos;
    }

    public void setLstEventos(List<Evento> lstEventos) {
        this.lstEventos = lstEventos;
    }
    
    

    @PostConstruct
    public void init() {
        limpiar();
        lstEventos = eventoRepository.buscarEventos();
    }
    
    public void limpiar() {
        evento = new Evento();
        lstSecciones.clear();
        lstLocalidades.clear();
        crearListaLocalidades();
        crearListaSecciones();
    }

    void crearListaSecciones() {
        lstSecciones.add(new Seccion(1, "Ultra Premium"));
        lstSecciones.add(new Seccion(2, "Premium"));
        lstSecciones.add(new Seccion(3, "VIP"));
        lstSecciones.add(new Seccion(4, "General"));
    }

    void crearListaLocalidades() {
        Integer estado = 10;
        lstLocalidades.add(new Localidad("G1", 4, estado));
        lstLocalidades.add(new Localidad("G10", 4, estado));
        lstLocalidades.add(new Localidad("G11", 4, estado));
        lstLocalidades.add(new Localidad("G12", 4, estado));
        lstLocalidades.add(new Localidad("G13", 4, estado));
        lstLocalidades.add(new Localidad("G14", 4, estado));
        lstLocalidades.add(new Localidad("G15", 4, estado));
        lstLocalidades.add(new Localidad("G16", 4, estado));
        lstLocalidades.add(new Localidad("G17", 4, estado));
        lstLocalidades.add(new Localidad("G18", 4, estado));
        lstLocalidades.add(new Localidad("G19", 4, estado));
        lstLocalidades.add(new Localidad("G2", 4, estado));
        lstLocalidades.add(new Localidad("G20", 4, estado));
        lstLocalidades.add(new Localidad("G21", 4, estado));
        lstLocalidades.add(new Localidad("G22", 4, estado));
        lstLocalidades.add(new Localidad("G23", 4, estado));
        lstLocalidades.add(new Localidad("G24", 4, estado));
        lstLocalidades.add(new Localidad("G25", 4, estado));
        lstLocalidades.add(new Localidad("G26", 4, estado));
        lstLocalidades.add(new Localidad("G27", 4, estado));
        lstLocalidades.add(new Localidad("G28", 4, estado));
        lstLocalidades.add(new Localidad("G29", 4, estado));
        lstLocalidades.add(new Localidad("G3", 4, estado));
        lstLocalidades.add(new Localidad("G30", 4, estado));
        lstLocalidades.add(new Localidad("G4", 4, estado));
        lstLocalidades.add(new Localidad("G5", 4, estado));
        lstLocalidades.add(new Localidad("G6", 4, estado));
        lstLocalidades.add(new Localidad("G7", 4, estado));
        lstLocalidades.add(new Localidad("G8", 4, estado));
        lstLocalidades.add(new Localidad("G9", 4, estado));
        lstLocalidades.add(new Localidad("P1", 2, estado));
        lstLocalidades.add(new Localidad("P10", 2, estado));
        lstLocalidades.add(new Localidad("P11", 2, estado));
        lstLocalidades.add(new Localidad("P12", 2, estado));
        lstLocalidades.add(new Localidad("P13", 2, estado));
        lstLocalidades.add(new Localidad("P14", 2, estado));
        lstLocalidades.add(new Localidad("P15", 2, estado));
        lstLocalidades.add(new Localidad("P16", 2, estado));
        lstLocalidades.add(new Localidad("P17", 2, estado));
        lstLocalidades.add(new Localidad("P18", 2, estado));
        lstLocalidades.add(new Localidad("P19", 2, estado));
        lstLocalidades.add(new Localidad("P2", 2, estado));
        lstLocalidades.add(new Localidad("P3", 2, estado));
        lstLocalidades.add(new Localidad("P4", 2, estado));
        lstLocalidades.add(new Localidad("P5", 2, estado));
        lstLocalidades.add(new Localidad("P6", 2, estado));
        lstLocalidades.add(new Localidad("P8", 2, estado));
        lstLocalidades.add(new Localidad("P9", 2, estado));
        lstLocalidades.add(new Localidad("UP1", 1, estado));
        lstLocalidades.add(new Localidad("UP10", 1, estado));
        lstLocalidades.add(new Localidad("UP11", 1, estado));
        lstLocalidades.add(new Localidad("UP12", 1, estado));
        lstLocalidades.add(new Localidad("UP2", 1, estado));
        lstLocalidades.add(new Localidad("UP3", 1, estado));
        lstLocalidades.add(new Localidad("UP4", 1, estado));
        lstLocalidades.add(new Localidad("UP5", 1, estado));
        lstLocalidades.add(new Localidad("UP6", 1, estado));
        lstLocalidades.add(new Localidad("UP7", 1, estado));
        lstLocalidades.add(new Localidad("UP8", 1, estado));
        lstLocalidades.add(new Localidad("UP9", 1, estado));
        lstLocalidades.add(new Localidad("VIP1", 3, estado));
        lstLocalidades.add(new Localidad("VIP10", 3, estado));
        lstLocalidades.add(new Localidad("VIP11", 3, estado));
        lstLocalidades.add(new Localidad("VIP12", 3, estado));
        lstLocalidades.add(new Localidad("VIP13", 3, estado));
        lstLocalidades.add(new Localidad("VIP14", 3, estado));
        lstLocalidades.add(new Localidad("VIP15", 3, estado));
        lstLocalidades.add(new Localidad("VIP16", 3, estado));
        lstLocalidades.add(new Localidad("VIP17", 3, estado));
        lstLocalidades.add(new Localidad("VIP18", 3, estado));
        lstLocalidades.add(new Localidad("VIP19", 3, estado));
        lstLocalidades.add(new Localidad("VIP2", 3, estado));
        lstLocalidades.add(new Localidad("VIP20", 3, estado));
        lstLocalidades.add(new Localidad("VIP21", 3, estado));
        lstLocalidades.add(new Localidad("VIP22", 3, estado));
        lstLocalidades.add(new Localidad("VIP23", 3, estado));
        lstLocalidades.add(new Localidad("VIP24", 3, estado));
        lstLocalidades.add(new Localidad("VIP3", 3, estado));
        lstLocalidades.add(new Localidad("VIP4", 3, estado));
        lstLocalidades.add(new Localidad("VIP5", 3, estado));
        lstLocalidades.add(new Localidad("VIP6", 3, estado));
        lstLocalidades.add(new Localidad("VIP7", 3, estado));
        lstLocalidades.add(new Localidad("VIP8", 3, estado));
        lstLocalidades.add(new Localidad("VIP9", 3, estado));

    }

    public void handleFileUpload(FileUploadEvent event) {
        evento.setFoto(event.getFile().getContent());
    }
    
    public void nuevoEvento(){
        limpiar();
    }

    @Transactional
    public void guardarEvento() {
        boolean esNuevo = true;
        if(evento.getIdevento() != null) {
            esNuevo = false;
        }
        evento.setEstado(10);
        evento = eventoRepository.guardarEvento(evento);
        lstSecciones.forEach(s -> {
                s.getSeccionPK().setIdevento(evento.getIdevento());
        });
        
        lstLocalidades.forEach(l -> {
            l.getLocalidadPK().setIdevento(evento.getIdevento());
        });
        seccionRepository.guardarSecciones(lstSecciones);
        if(esNuevo) 
            localidadRepository.actualizarLocalidad(lstLocalidades);
        

    }
    
    public void seleccionarEvento(Evento eventoSel) {
        evento = eventoSel;
        lstSecciones = seccionRepository.getSeccionesByEvento(evento.getIdevento());
    }
}
