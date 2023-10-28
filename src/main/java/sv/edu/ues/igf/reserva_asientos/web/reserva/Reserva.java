/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.web.reserva;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class Reserva implements Serializable {
    
    private List<Localidad> localidades;

    @PostConstruct
    public void init(){
        
        localidades = List.of(
                new Localidad(0, 10, new BigDecimal("10.5")),
                new Localidad(1, 10, new BigDecimal("15.5")),
                new Localidad(2, 10, new BigDecimal("11.5")),
                new Localidad(3, 10, new BigDecimal("10.5")),
                new Localidad(4, 10, new BigDecimal("15.5")),
                new Localidad(5, 10, new BigDecimal("10.5")),
                new Localidad(6, 10, new BigDecimal("15.5")),
                new Localidad(7, 10, new BigDecimal("15.5")));
        System.out.println("welcome -> " + localidades);
    }
    
    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }
    
    public void changeStatus(Localidad localidad){
        localidades.stream().filter(l -> l.getId() == localidad.getId()).toList().get(0).setStatus(localidad.getStatus() == 20 ? 10 : 20);
        System.out.println("new -> " + localidades);
    }
}
