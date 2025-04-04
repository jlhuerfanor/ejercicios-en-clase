package co.edu.etitc.programacion;

import org.springframework.stereotype.Component;

@Component
public class SistemaPagos {

    public void pagarEfectivo(int value) {
        if(value > 1000) {
            throw new IllegalArgumentException("El pago en efectivo no puede ser mayor a 1000 pesos");
        }
        System.out.printf("Se esta pagando en efectivo un monto de %d...%n", value);
    }

    public void pagarTarjeta(int value) {
        if(value > 100000) {
            throw new IllegalArgumentException("El pago con tarjeta no puede ser mayor a 1000000 pesos");
        }
        System.out.printf("Se esta pagando con tarjeta un monto de %d...%n", value);
    }

    public void pagarPse(int value) {
        if(value > 10000) {
            throw new IllegalArgumentException("El pago con tarjeta no puede ser mayor a 100000 pesos");
        }
        System.out.printf("Se esta pagando por PSE un monto de %d...%n", value);
    }

    
}
