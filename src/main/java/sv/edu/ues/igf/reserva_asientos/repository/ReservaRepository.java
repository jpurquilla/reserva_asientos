/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class ReservaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public Reserva guardarReserva(Reserva reserva){
        entityManager.persist(reserva);
        return reserva;
    }                                
}
