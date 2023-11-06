package sv.edu.ues.igf.reserva_asientos.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idpersona;
    private String nombres;
    private String apellidos;
    private String dui;
    private String email;
    private String telefono;
//    @OneToOne(mappedBy = "persona",cascade = )
//    private Usuario usuario;

    public Persona() {
    }

    public Persona(String nombres, String apellidos, String dui, String email, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.email = email;
        this.telefono = telefono;
    }
    
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
    
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return idpersona == persona.idpersona && Objects.equals(nombres, persona.nombres) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(dui, persona.dui) && Objects.equals(email, persona.email) && Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpersona, nombres, apellidos, dui, email, telefono);
    }
}
