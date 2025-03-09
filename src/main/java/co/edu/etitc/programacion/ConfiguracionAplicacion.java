package co.edu.etitc.programacion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Esta es la clase de configuracion de la aplicacion. 
 * <p>
 * Observaciones:
 * <ul>
 *  <li>Con la anotación {@link Configuration} le indicamos a Spring que esta clase es un componente de configuración.
 *  <li>{@link ComponentScan} le indica a Spring que escanee el paquete {@link co.edu.etitc.programacion}
 *  <li>{@link PropertySource} le indica a Spring que debe leer el archivo correspondiente para
 *  obtener las propiedades de la aplicacion. Dentro del archivo .properties podemos definir diferentes propiedades en 
 *  formato "nombre.propiedad=valor"
 * </ul>
 */
@Configuration
@ComponentScan({
    "co.edu.etitc.programacion"
})
@PropertySource("classpath:application.properties")
@PropertySource("classpath:modulo1.properties")
public class ConfiguracionAplicacion {
    
}
