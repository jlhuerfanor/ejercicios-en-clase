package co.edu.etitc.programacion;

/**
 * Recordemos que una interfaz define un contrato, donde se pide que se debe hacer
 * pero no se indica el cómo debe hacerlo. Aquellos que la implementan deben definir
 * el cómo.
 * <p>
 * En este ejemplo tenemos 2 implementaciones: {@link HolaAplicacion} y {@link HolaMundo},
 * las cuales implementan el método {@link Saludar#saludar()} de diferente forma.
 */
public interface Saludar {
    void saludar();
}
