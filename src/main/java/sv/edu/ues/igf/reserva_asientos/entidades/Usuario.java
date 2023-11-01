package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Usuario {
    
    @Id
    private String codusr;

    private String password;

    private LocalDateTime fechacrea;

   
    @ManyToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona",insertable=false, updatable=false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil",insertable=false, updatable=false)
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(String codusr, String password, Persona persona, Perfil perfil) {
        this.codusr = codusr;
        this.password = password;
        this.persona = persona;
        this.perfil = perfil;
        this.fechacrea = LocalDateTime.now();
    }

    
    
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codusr, other.codusr)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.fechacrea, other.fechacrea);
    }

    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codusr);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.fechacrea);
        return hash;
    }

    


    @Override
    public String toString() {
        return "Usuario{" +
                "codusr='" + codusr + '\'' +
                ", password='" + password + '\'' +
                ", fechacrea=" + fechacrea +
                ", persona=" + persona +
                ", perfil=" + perfil +
                '}';
    }
}
