package co.edu.etitc.programacion.contexto;

import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando mensaje por email: " + mensaje);
    }
}
