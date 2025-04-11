package co.edu.etitc.programacion;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "USUARIO")
public class Usuario {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    @Column("CORREO")
    private String email;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Integer getEdad() {
        return edad;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public void setEmail(String correo) {
        this.email = correo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "id: %d, nombre: %s %s, edad: %d, email: %s%n".formatted(
            id, nombre, apellido, edad, email
        );
    }
}
