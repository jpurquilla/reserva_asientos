/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;
import sv.edu.ues.igf.reserva_asientos.entidades.Reservadetalle;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class ReservadetalleRepository {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Transactional
    public void guardarReservaDetalle(Reservadetalle reservadetalle){
        entityManager.persist(reservadetalle);
    }          
}
