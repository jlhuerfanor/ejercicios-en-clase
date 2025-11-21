package co.edu.etitc.programacion.web.modelo;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario() { }

    public Usuario(
        int id,
        String nombre,
        String apellido,
        int edad
    ) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }
}
