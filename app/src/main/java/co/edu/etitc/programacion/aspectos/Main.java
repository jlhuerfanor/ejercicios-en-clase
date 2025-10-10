package co.edu.etitc.programacion.aspectos;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ConfiguracionAplicacion.class)) {
            SistemaPagos sistemaPagos = context.getBean(SistemaPagos.class);
            sistemaPagos.pagar("pepe", 5000, MedioPago.EFECTIVO);
            sistemaPagos.pagar("juanito", 950000, MedioPago.TARJETA);
            sistemaPagos.pagar("pepe", 650, MedioPago.EFECTIVO);
            sistemaPagos.pagar("juanito", 150000, MedioPago.TARJETA);
            sistemaPagos.pagar("pepe", 800, MedioPago.EFECTIVO);
            sistemaPagos.pagar("juanito", 200000, MedioPago.TARJETA);
            sistemaPagos.pagar("pepe", 10, MedioPago.EFECTIVO);
            sistemaPagos.pagar("juanito", 350000, MedioPago.TARJETA);
        }
    }
}
