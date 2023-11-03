/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sv.edu.ues.igf.reserva_asientos.entidades.Localidad;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class LocalidadRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Localidad> getLocalidadesByEvento(int idevento){
        return entityManager.createQuery("select l from Localidad l where l.localidadPK.idevento = :idevento", Localidad.class)
        .setParameter("idevento",idevento).getResultList();
    }
    
    @Transactional
    public Localidad actualizarLocalidad(Localidad localidad){
        entityManager.merge(localidad);
        return localidad;
    }
    
}
