package co.edu.etitc.programacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("co.edu.etitc.programacion")
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(
            Main.class);

        // Scope Singleton: Devuelve la misma instancia siempre
        // Es el scope por defecto.
        EjemploBeanAdministrado1 ejemplo1A = contexto.getBean(EjemploBeanAdministrado1.class);
        EjemploBeanAdministrado1 ejemplo1B = contexto.getBean(EjemploBeanAdministrado1.class);
        // Scope Singleton: Devuelve una instancia diferente cada vez que se pide
        // No es destruido por el contexto de spring
        EjemploBeanAdministrado2 ejemplo2A = contexto.getBean(EjemploBeanAdministrado2.class);
        EjemploBeanAdministrado2 ejemplo2B = contexto.getBean(EjemploBeanAdministrado2.class);
        
        System.out.printf("ejemplo1A == ejemplo1B ?: %s%n", ejemplo1A == ejemplo1B);
        System.out.printf("ejemplo2A == ejemplo2B ?: %s%n", ejemplo2A == ejemplo2B);

        contexto.close();
    }
}