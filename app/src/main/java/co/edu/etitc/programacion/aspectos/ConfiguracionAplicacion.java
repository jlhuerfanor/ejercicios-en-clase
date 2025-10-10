package co.edu.etitc.programacion.aspectos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
// @Import({SistemaPagos.class, SaldoCuenta.class, SesionUsuario.class})
@ComponentScan("co.edu.etitc.programacion.aspectos")
@EnableAspectJAutoProxy
public class ConfiguracionAplicacion {
    
}
