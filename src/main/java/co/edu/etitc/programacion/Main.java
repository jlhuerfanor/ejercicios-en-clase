package co.edu.etitc.programacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(
            ConfiguracionAplicacion.class);
        Saludar instancia = contexto.getBean(Saludar.class);

        System.out.println(contexto.getEnvironment().getProperty("nombre.aplicacion"));

        instancia.saludar();

        contexto.close();
    }
}