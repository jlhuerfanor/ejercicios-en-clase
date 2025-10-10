package co.edu.etitc.programacion.ciclodevida;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Clase que representa un bean con el ciclo de vida
 */
@Component
public class EjemploCicloDeVidaBean implements DisposableBean, InitializingBean {

    /**
     * Metodo que se ejecuta despues de crear el bean
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Se ejecuto el metodo afterPropertiesSet del bean EjemploCicloDeVidaBean");
    }

    /**
     * Metodo que se ejecuta antes de destruir el bean
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Se ejecuto el metodo destroy del bean EjemploCicloDeVidaBean");
    }
}
