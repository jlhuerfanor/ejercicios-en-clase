package co.edu.etitc.programacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("co.edu.etitc.programacion")
public class Main {

    @Bean(initMethod = "inicializar", destroyMethod = "destruir")
    public EjemploBeanAdministrado3 ejemploBeanAdministrado3() {
        return new EjemploBeanAdministrado3();
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(
            Main.class);

        EjemploBeanAdministrado1 ejemplo1 = contexto.getBean(EjemploBeanAdministrado1.class);
        EjemploBeanAdministrado2 ejemplo2 = contexto.getBean(EjemploBeanAdministrado2.class);
        EjemploBeanAdministrado3 ejemplo3 = contexto.getBean(EjemploBeanAdministrado3.class);
        
        contexto.close();
    }
}