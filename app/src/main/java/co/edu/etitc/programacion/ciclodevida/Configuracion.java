package co.edu.etitc.programacion.ciclodevida;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    /**
     * Metodo que retorna un bean de la clase ConexionBaseDeDatos, con los metodos de ciclo de vida configurados
     * {@link Bean#initMethod()} y {@link Bean#destroyMethod()}
     * @return
     */
    @Bean(initMethod = "abrirConexion", destroyMethod = "cerrarConexion")
    public ConexionBaseDeDatos conexionBaseDeDatos() {
        return new ConexionBaseDeDatos();
    }
}
