package co.edu.etitc.programacion.contexto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRegistroManual {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext()) {
            context.register(NotificadorEmail.class);
            context.register(NotificadorSms.class);
            context.refresh();
            
            Notificador notificadorEmail = context.getBean(NotificadorEmail.class);
            Notificador notificadorSms = context.getBean(NotificadorSms.class);
            
            notificadorEmail.notificar("Hola");
            notificadorSms.notificar("Hola");
        }
    }
}
