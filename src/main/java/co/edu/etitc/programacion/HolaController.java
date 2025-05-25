package co.edu.etitc.programacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaController {
    
    @GetMapping("/hola")
    @ResponseBody
    public String hola(
        @RequestParam("nombre") String nombre,
        @RequestParam("apellido") String apellido
    ) {
        return "Hola %s %s desde el servidor!".formatted(nombre, apellido);
    }
    
}
