package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String codusr;

    private String password;

    private LocalDateTime fechacrea;

    private Integer idpersona;

    private Integer idperfil;
    @ManyToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona",insertable=false, updatable=false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil",insertable=false, updatable=false)
    private Perfil perfil;

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechacrea() {
        return fechacrea;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setFechacrea(LocalDateTime fechacrea) {
        this.fechacrea = fechacrea;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codusr, usuario.codusr) && Objects.equals(password, usuario.password) && Objects.equals(fechacrea, usuario.fechacrea) && Objects.equals(idpersona, usuario.idpersona) && Objects.equals(idperfil, usuario.idperfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codusr, password, fechacrea, idpersona, idperfil);
    }

//    public Persona getPersonaByIdpersona() {
//        return personaByIdpersona;
//    }
//
//    public void setPersonaByIdpersona(Persona personaByIdpersona) {
//        this.personaByIdpersona = personaByIdpersona;
//    }
//
//    public Perfil getPerfilByIdperfil() {
//        return perfilByIdperfil;
//    }
//
//    public void setPerfilByIdperfil(Perfil perfilByIdperfil) {
//        this.perfilByIdperfil = perfilByIdperfil;
//    }


    @Override
    public String toString() {
        return "Usuario{" +
                "codusr='" + codusr + '\'' +
                ", password='" + password + '\'' +
                ", fechacrea=" + fechacrea +
                ", idpersona=" + idpersona +
                ", idperfil=" + idperfil +
                ", persona=" + persona +
                ", perfil=" + perfil +
                '}';
    }
}
