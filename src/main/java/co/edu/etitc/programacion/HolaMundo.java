package co.edu.etitc.programacion;

import org.springframework.stereotype.Component;

/**
 * HolaMundo es otra clase ejemplo de componente de aplicacion.
 * <p>
 * Los componentes reflejan las partes de la lógica de nuestra aplicación.
 * <p>
 * En este ejemplo, tambien implementa la interfaz {@link Saludar} y sive como
 * una implementación alternativa a {@link HolaAplicacion}.
 */
@Component
public class HolaMundo implements Saludar {
    public void saludar() {
        System.out.println("Hola mundo!");
    }
}
