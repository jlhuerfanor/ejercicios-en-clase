package co.edu.etitc.programacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        try(var contexto = new AnnotationConfigApplicationContext(
            ConfiguracionAplicacion.class)) {
            SesionUsuario sesion = contexto.getBean(SesionUsuario.class);
            SistemaPagos pagos = contexto.getBean(SistemaPagos.class);

            sesion.setUsuario("Pepito Peres");
            pagos.pagarEfectivo(1000);
            System.out.println();

            sesion.setUsuario("Juanito Alimania");
            pagos.pagarTarjeta(1000);
            System.out.println();

            sesion.setUsuario("Luisito Comunica");
            pagos.pagarPse(1000000);
            System.out.println();
        } 
    }
}