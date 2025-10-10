package co.edu.etitc.programacion.contexto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que representa la configuracion de la aplicacion. Tiene dos metodos que retornan 
 * beans de las clases NotificadorEmail y NotificadorSms
 */
@Configuration
public class ConfiguracionAplicacion {
    
    /**
     * Metodo que retorna un objeto de la clase NotificadorEmail. Toma el nombre del metodo como el nombre del bean
     * @return
     */
    @Bean
    public NotificadorEmail notificadorEmail() {
        return new NotificadorEmail();
    }

    /**
     * Metodo que retorna un objeto de la clase NotificadorSms. Toma el nombre pasado en el argumento como el nombre del bean
     * @return
     */
    @Bean(name = "notificadorSms")
    public NotificadorSms notificadorSms() {
        return new NotificadorSms();
    }

}
