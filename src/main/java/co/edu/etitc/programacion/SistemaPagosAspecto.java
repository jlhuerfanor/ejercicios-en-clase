package co.edu.etitc.programacion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SistemaPagosAspecto {

    private final SesionUsuario sesionUsuario;

    public SistemaPagosAspecto(SesionUsuario sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

    @Before("execution(* co.edu.etitc.programacion.SistemaPagos.*(..))")
    public void registrarInicioTransaccion(JoinPoint joinPoint) {
        System.out.printf("%s ha iniciado una transacción por %s.%n", 
                sesionUsuario.getUsuario(),
                joinPoint.getArgs()[0]);
    }

    @After("execution(* co.edu.etitc.programacion.SistemaPagos.*(..))")
    public void registrarFinTransaccion(JoinPoint joinPoint) {
        System.out.printf("%s ha finalizado una transacción por %s.%n", 
                sesionUsuario.getUsuario(),
                joinPoint.getArgs()[0]);
    }

    @AfterThrowing(
        pointcut = "execution(* co.edu.etitc.programacion.SistemaPagos.*(..))",
        throwing = "ex")
    public void registrarErrorTransaccion(JoinPoint joinPoint, Exception ex) {
        System.out.printf("ERROR: La transacción del usuario %s por %s ha finalizado con error: %s.%n", 
                sesionUsuario.getUsuario(),
                joinPoint.getArgs()[0],
                ex.getMessage());
    }
}
