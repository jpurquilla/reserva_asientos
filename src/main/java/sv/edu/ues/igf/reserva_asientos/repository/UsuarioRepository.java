package sv.edu.ues.igf.reserva_asientos.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.igf.reserva_asientos.entidades.Persona;
import sv.edu.ues.igf.reserva_asientos.entidades.Usuario;

@ApplicationScoped
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Usuario listarUsuarios(String codusr) {
        try {
            return entityManager.createQuery("select u from Usuario u where u.codusr = :codusr", Usuario.class)
                    .setParameter("codusr", codusr).getSingleResult();
        }   catch (NoResultException nre) {
               return null;
        }

    }

public void guardarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }
    
    public Usuario

buscarUsuarioPorId(String codusr) {
        return entityManager.find(Usuario.class  

, codusr);
    }
    
    public void eliminarUsuario(String codusr ) {
         Usuario usuario = buscarUsuarioPorId(codusr);
         entityManager.remove(usuario);
     }
}
