package co.edu.etitc.programacion.ciclodevida;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(Configuracion.class, EjemploCicloDeVidaBean.class)) {
            context.getBean(EjemploCicloDeVidaBean.class);
            context.getBean(ConexionBaseDeDatos.class);

            System.out.println("Cerrando el contexto");
        }
    }
}
