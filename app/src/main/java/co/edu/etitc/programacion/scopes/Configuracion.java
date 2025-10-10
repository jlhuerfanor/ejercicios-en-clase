package co.edu.etitc.programacion.scopes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Configuracion {

    /**
     * Metodo que retorna un bean de la clase ConexionBaseDeDatos, con los metodos de ciclo de vida configurados
     * {@link Bean#initMethod()} y {@link Bean#destroyMethod()}
     * @return
     */
    @Bean(initMethod = "abrirConexion", destroyMethod = "cerrarConexion")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ConexionBaseDeDatos conexionBaseDeDatos() {
        return new ConexionBaseDeDatos();
    }
}
