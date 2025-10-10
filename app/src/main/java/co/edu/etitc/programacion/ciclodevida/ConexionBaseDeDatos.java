package co.edu.etitc.programacion.ciclodevida;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Ejemplo de conexion a la base de datos. Representa una clase que no se puede modificar.
 * En este caso se usará los attibutos de la anotacion
 * {@link Bean#initMethod()} y {@link Bean#destroyMethod()} para indicar los metodos que se deben ejecutar
 * durante el ciclo de vida de la conexion.
 */
public class ConexionBaseDeDatos {
    public void abrirConexion() {
        System.out.println("Se abrio conexion con la base de datos");
    }

    public void cerrarConexion() {
        System.out.println("Se cerro conexion con la base de datos");
    }
}
