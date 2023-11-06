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
         return entityManager.merge(persona);
         
     }
     
     public Persona buscarPersona(Integer idPersona) {
         return (Persona) entityManager.createQuery("select c from Persona c where idpersona = :idpersona")
                 .setParameter("idpersona", idPersona).getSingleResult();
     }
     
     public Persona buscarPersonaPorId(Integer idPersona) {
         return entityManager.find(Persona.class, idPersona);
     }
     
     public void eliminarPersona (Integer idPersona) {
          Persona persona = buscarPersonaPorId(idPersona);
          entityManager.remove(persona);
     }
}
