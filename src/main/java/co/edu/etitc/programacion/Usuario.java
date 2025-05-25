package co.edu.etitc.programacion;

public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario() { }
    
    public Usuario(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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
}
