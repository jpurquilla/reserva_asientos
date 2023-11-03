
package sv.edu.ues.igf.reserva_asientos.web.admin;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.IOUtils;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Seccion;

@Named
@RequestScoped
public class Eventos {
    private Evento evento = new Evento();
    private LocalDate fechaMinima = LocalDate.now();
    private LocalTime hora;
    private List<Seccion> lstSecciones =new ArrayList<>();
    private final  String []  seccionesArray = {"Ultra Premium", "Premium","VIP","General"};

    
    

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
    
    
    @PostConstruct
    public void init() {
        lstSecciones = Stream.of(seccionesArray)
                .map(s -> {
                  Seccion seccion = new Seccion();
                  seccion.setNombre(s);
                  return seccion;
                }).toList();
    }
    
    
    
    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        evento.setFoto(event.getFile().getContent());
    }
}
