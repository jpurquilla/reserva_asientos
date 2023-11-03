/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.portal;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.repository.ReservaRepository;
/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class Historico implements Serializable{
    
    @Inject
    private ReservaRepository reservaRepository;
    
    private List<Reserva> reservas;

    @PostConstruct
    public void init(){
        reservas = reservaRepository.getReservasByPersona(1);
    }
    
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
 
}
