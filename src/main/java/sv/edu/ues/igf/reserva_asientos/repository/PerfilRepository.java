/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Perfil;

@ApplicationScoped
public class PerfilRepository {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Perfil> listarPerfiles() {
        return entityManager.createQuery("select p from Perfil p").getResultList();
    }
}
