package co.edu.etitc.programacion.aspectos;

import org.springframework.stereotype.Component;

@Component
public class SesionUsuario {
    private String nombre;

    public void iniciarSesion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void cerrarSesion() {
        this.nombre = null;
    }
    
}
