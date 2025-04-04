package co.edu.etitc.programacion;

import org.springframework.stereotype.Component;

@Component
public class SesionUsuario {
    private String usuario;

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String valor) {
        this.usuario = valor;
    }
}
