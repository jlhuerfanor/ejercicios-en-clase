package co.edu.etitc.programacion;

public class EjemploBeanAdministrado3 {

    public void inicializar() throws Exception {
        System.out.println("EjemploBeanAdministrado3 inicializado desde @Bean(initMethod=...)");
    }

    public void destruir() throws Exception {
        System.out.println("EjemploBeanAdministrado3 destruido desde @Bean(destroyMethod=...)");
    }
}
