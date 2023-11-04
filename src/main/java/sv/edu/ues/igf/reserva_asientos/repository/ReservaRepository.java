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
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import sv.edu.ues.igf.reserva_asientos.entidades.Reserva;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class ReservaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Reserva> getReservasByPersona(int idpersona){
        return entityManager.createQuery("select r from Reserva r where r.idpersona = :idpersona", Reserva.class)
        .setParameter("idpersona",idpersona).getResultList();
    }
    
    public Reserva buscarEventoById(int idreserva){
        return entityManager.find(Reserva.class, idreserva);
    }
    
    @Transactional
    public Reserva guardarReserva(Reserva reserva){
        entityManager.persist(reserva);
        return reserva;
    }
    
    @Transactional
    public Reserva actualizarReserva(Reserva reserva){
        entityManager.merge(reserva);
        return reserva;
    }    
}
