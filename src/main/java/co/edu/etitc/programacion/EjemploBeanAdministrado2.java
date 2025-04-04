package co.edu.etitc.programacion;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class EjemploBeanAdministrado2 {

    /**
     * Metodo de inicializacion del bean. Se llama una vez despues de creado
     */
    @PostConstruct
    public void inicializar() throws Exception {
        System.out.println("EjemploBeanAdministrado2 inicializado desde metodo anotado con @PostConstruct");
    }

    /**
     * Metodo de destruccion del bean. Se llama una vez antes de ser destruido
     */
    @PreDestroy
    public void destruir() throws Exception {
        System.out.println("EjemploBeanAdministrado2 destruido desde metodo anotado con @PreDestroy");
    }
}
