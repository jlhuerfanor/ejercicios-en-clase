package co.edu.etitc.programacion;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

/**
 * Clase que implementa {@link Supplier} y provee la fecha y hora actual. Se usa como
 * dependencia en {@link HolaAplicacion}
 */
@Component
public class ProveedorFechaHora implements Supplier<LocalDateTime> {
    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}
