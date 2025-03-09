package co.edu.etitc.programacion;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * HolaAplicacion es una clase ejemplo de componente de aplicacion.
 * <p>
 * Los componentes reflejan las partes de la lógica de nuestra aplicación.
 * 
 * En este ejemplo, implementa la interfaz {@link Saludar} y define un método el cual es
 * {@link Saludar#saludar()}.
 */
@Component
@Primary
public class HolaAplicacion implements Saludar {
    private final Supplier<LocalDateTime> proveedorFechaHora;
    private final String nombreAplicacion;

    /**
     * Este es el constructor donde inyectamos las dependencias de la 
     * aplicacion. Cada parametro le indica a Spring que debe proveer una instancia
     * del tipo especificado.
     * @param proveedorFechaHora Le indica a Spring que debe proveer una instancia de
     * tipo {@link Supplier}. Spring debe buscar en su contenedor una instancia de este o
     * en caso de no tenerla, crearla a partir de la configuracion de la aplicacion.
     * @param nombreAplicacion La anotacion {@link Value} le indica a Spring que debe
     * evaluar la expresion indicada y retornar el valor resultante. En este caso,
     * debe devolver el valor de la propiedad "nombre.aplicacion" la cual puede ser
     * establecida bien en el archivo de configuracion (.properties), en el sistema 
     * (a travez de variables de la máquina virtual al momento de ejecutar el programa)
     * o a travez de las variables de entorno (recordar la regla de nombres: NOMBRE_APLICACION)
     */
    public HolaAplicacion(
        Supplier<LocalDateTime> proveedorFechaHora,
        @Value("${nombre.aplicacion}") String nombreAplicacion) {
        this.proveedorFechaHora = proveedorFechaHora;
        this.nombreAplicacion = nombreAplicacion;
    }

    @Override
    public void saludar() {
        System.out.printf(
            "Hola, mi nombre es %s y son las %s%n", nombreAplicacion, proveedorFechaHora.get());
    }
}
