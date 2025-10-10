package co.edu.etitc.programacion.aspectos;

import org.springframework.stereotype.Component;

@Component
public class SistemaPagos {
    private final SesionUsuario sesionUsuario;
    private final SaldoCuenta saldoCuenta;

    public SistemaPagos(SesionUsuario sesionUsuario, SaldoCuenta saldoCuenta) {
        this.sesionUsuario = sesionUsuario;
        this.saldoCuenta = saldoCuenta;
    }

    public void pagar(String usuario, int monto, MedioPago medioPago) {
        sesionUsuario.iniciarSesion(usuario);
        saldoCuenta.sumarAlSaldo(monto);
        sesionUsuario.cerrarSesion();
    }
    
}
