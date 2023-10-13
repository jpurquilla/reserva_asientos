package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;

import java.util.List;


@ApplicationScoped
public class UsuarioRepository   {

    @PersistenceContext
    private EntityManager entityManager;


    public Usuario buscarUsuario(String codusr) {

        return entityManager.createQuery("select u from Usuario u where codusr = :codusr",Usuario.class)
                .setParameter("codusr",codusr).getSingleResult();
    }
}
