package co.edu.etitc.programacion.basedatos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USUARIO")
public class Usuario {
    @Id
    @Column("ID")
    private Integer id;
    @Column("NOMBRE")
    private String nombre;
    @Column("APELLIDO")
    private String apellido;
    @Column("EDAD")
    private int edad;

    public Integer getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
