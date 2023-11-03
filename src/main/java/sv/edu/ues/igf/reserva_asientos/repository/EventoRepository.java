/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Evento;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class EventoRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Evento> buscarEventos() {
        return entityManager.createQuery("select e from Evento e",Evento.class)
                .getResultList();
    }
    
}
