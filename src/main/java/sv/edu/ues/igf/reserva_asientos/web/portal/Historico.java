/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.ues.igf.reserva_asientos.repository.EventoRepository;
import sv.edu.ues.igf.reserva_asientos.repository.ReservaRepository;
import sv.edu.ues.igf.reserva_asientos.web.configuracion.SessionBean;

/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class Historico implements Serializable {

    @Inject
    private ReservaRepository reservaRepository;

    @Inject
    SessionBean sessionBean;

    private List<Reserva> reservas;

    @PostConstruct
    public void init() {
        if(sessionBean.getIdpersona() == null || sessionBean.getIdperfil() == null) {
            try {               
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect(externalContext.getRequestContextPath() + "/portal/principal.xhtml");               
                return;
            } catch (IOException ex) {
                Logger.getLogger(ReservaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        reservas = reservaRepository.getReservasByPersona(!sessionBean.getIdperfil().equals(10) ? sessionBean.getIdpersona() : null);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getTimeFormatted(LocalTime time) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return time.format(dtFormatter);
    }

    public String getDateFormatted(LocalDate time) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return time.format(dtFormatter);
    }
}
