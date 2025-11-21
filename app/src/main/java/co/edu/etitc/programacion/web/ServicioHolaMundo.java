package co.edu.etitc.programacion.web;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioHolaMundo implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inicializado");
    }

    @GetMapping("/saludo")
    public ResponseEntity<String> saludarGet(
        @RequestParam("nombre") String nombre,
        @RequestParam("apellido") String apellido
    ) {
        return ResponseEntity.ok("Hola %s %s!".formatted(nombre, apellido));
    }
}
