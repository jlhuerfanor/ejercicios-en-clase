package co.edu.etitc.programacion.contexto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRegistroPorAnotaciones {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(NotificadorEmail.class, NotificadorSms.class)) {
            context.getBean(NotificadorEmail.class).notificar("Hola");
            context.getBean(NotificadorSms.class).notificar("Hola");
        }
    }
}
