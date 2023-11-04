/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import sv.edu.ues.igf.reserva_asientos.entidades.Seccion;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class SeccionRepository implements Serializable {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Seccion> getSeccionesByEvento(int idevento){
        return entityManager.createQuery("select s from Seccion s where s.seccionPK.idevento = :idevento", Seccion.class)
        .setParameter("idevento", idevento).getResultList();
    }
    
    
    public void guardarSecciones (List<Seccion> lstSecciones) {
        System.out.println("tamaño de la lista secciones --> " + lstSecciones.size());
        lstSecciones.forEach(s -> {entityManager.merge(s);});
    }
    
}
