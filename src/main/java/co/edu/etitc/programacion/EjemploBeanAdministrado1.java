package co.edu.etitc.programacion;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Spring automaticamente administra el ciclo de vida de este bean
 * llamando a los diferentes métodos de inicializacion / destruccion
 */
@Component
@Scope(value = BeanDefinition.SCOPE_SINGLETON) // Scope singleton
public class EjemploBeanAdministrado1 
    implements InitializingBean, DisposableBean
{
    /**
     * Metodo de inicializacion del bean. Se llama una vez despues de creado
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EjemploBeanAdministrado1 inicializado desde DisposableBean.afterPropertiesSet");
    }

    /**
     * Metodo de destruccion del bean. Se llama una vez antes de ser destruido
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("EjemploBeanAdministrado1 destruido desde DisposableBean.destroy");
    }
}
