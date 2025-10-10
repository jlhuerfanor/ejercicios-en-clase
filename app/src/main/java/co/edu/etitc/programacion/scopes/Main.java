package co.edu.etitc.programacion.scopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * Scopes de Spring: https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
     * @param args
     */
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(Configuracion.class, EjemploCicloDeVidaBean.class)) {
            EjemploCicloDeVidaBean ejemploCicloDeVidaBean = context.getBean(EjemploCicloDeVidaBean.class);
            ConexionBaseDeDatos conexionBaseDeDatos = context.getBean(ConexionBaseDeDatos.class);

            EjemploCicloDeVidaBean instancia2EjemploCicloDeVidaBean = context.getBean(EjemploCicloDeVidaBean.class);
            ConexionBaseDeDatos instancia2ConexionBaseDeDatos = context.getBean(ConexionBaseDeDatos.class);

            if(ejemploCicloDeVidaBean == instancia2EjemploCicloDeVidaBean) {
                System.out.println("Las instancias del bean de EjemploCicloDeVidaBean son iguales");
            } else {
                System.out.println("Las instancias del bean de EjemploCicloDeVidaBean son diferentes");
            }

            if(conexionBaseDeDatos == instancia2ConexionBaseDeDatos) {
                System.out.println("Las instancias del bean de ConexionBaseDeDatos son iguales");
            } else {
                System.out.println("Las instancias del bean de ConexionBaseDeDatos son diferentes");
            }

            System.out.println("Cerrando el contexto");
        }
    }
}
