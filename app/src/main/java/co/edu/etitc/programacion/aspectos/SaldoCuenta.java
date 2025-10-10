package co.edu.etitc.programacion.aspectos;

import org.springframework.stereotype.Component;

@Component
public class SaldoCuenta {
    private int saldo = 0;

    public int getSaldo() {
        return saldo;
    }

    public void sumarAlSaldo(int valor) {
        this.saldo += valor;
    }
}
