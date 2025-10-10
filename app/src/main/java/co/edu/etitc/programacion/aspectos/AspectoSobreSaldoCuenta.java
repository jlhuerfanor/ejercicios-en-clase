package co.edu.etitc.programacion.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Aspect
public class AspectoSobreSaldoCuenta {
    private final SesionUsuario sesionUsuario;
    private final SaldoCuenta saldoCuenta;
    
    public AspectoSobreSaldoCuenta(SesionUsuario sesionUsuario, SaldoCuenta saldoCuenta) {
        this.sesionUsuario = sesionUsuario;
        this.saldoCuenta = saldoCuenta;
    }
    
    @Before("execution(* co.edu.etitc.programacion.aspectos.SaldoCuenta.sumarAlSaldo(..))")
    public void registrarValorTransaccion(JoinPoint joinPoint) {
        System.out.printf("El usuario %s ha realizado una transaccion de $%d%n", 
            sesionUsuario.getNombre(), joinPoint.getArgs()[0]);
    }

    @After("execution(* co.edu.etitc.programacion.aspectos.SaldoCuenta.sumarAlSaldo(..))")
    public void actualizarSaldo() {
        System.out.printf("El saldo actual es de $%d%n", saldoCuenta.getSaldo());
    }
    
    @Before("execution(* co.edu.etitc.programacion.aspectos.SistemaPagos.pagar(..))")
    public void validarMontos(JoinPoint joinPoint) {
        MedioPago medioPago = (MedioPago) joinPoint.getArgs()[2];
        int monto = (int) joinPoint.getArgs()[1];

        switch (medioPago) {
            case EFECTIVO:
                if (monto > 1000) {
                    throw new RuntimeException("No se puede pagar con efectivo mas de $1000");
                }
                break;
            case TARJETA:
                if (monto > 1000000) {
                    throw new RuntimeException("No se puede pagar con tarjeta mas de $1000000");
                }
                break;
        }
    }
    
    // Pendiente:
    @AfterThrowing("execution(* co.edu.etitc.programacion.aspectos.SistemaPagos.pagar(..))")
    public void registrarError(JoinPoint joinPoint, Exception ex) {
        System.out.printf("Ocurrio un error al pagar: %s", ex.getMessage());
    }
}
