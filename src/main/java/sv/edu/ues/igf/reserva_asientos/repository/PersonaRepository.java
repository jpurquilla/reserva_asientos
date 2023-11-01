/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Persona;

@ApplicationScoped
public class PersonaRepository {
    @PersistenceContext
    private EntityManager entityManager;
     
     public List<Persona> listarPersonas () {
         return entityManager.createQuery("select c from Persona c").getResultList();
     }
     
     public Persona guardarPersona(Persona persona) {
         entityManager.persist(persona);
         return persona;
     }
     
     public Persona buscarPersonaPorId(Integer idPersona) {
         return entityManager.find(Persona.class, idPersona);
     }
     
     public void eliminarPersona (Integer idPersona) {
          Persona persona = buscarPersonaPorId(idPersona);
          entityManager.remove(persona);
     }
}
