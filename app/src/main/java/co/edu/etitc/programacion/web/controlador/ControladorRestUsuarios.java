package co.edu.etitc.programacion.web.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.etitc.programacion.web.modelo.Usuario;
import co.edu.etitc.programacion.web.servicio.ServicioUsuarios;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorRestUsuarios {

    private final ServicioUsuarios servicioUsuarios;

    public ControladorRestUsuarios(ServicioUsuarios servicioUsuarios) {
        this.servicioUsuarios = servicioUsuarios;
    }
    
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return servicioUsuarios.obtenerUsuarios();
    }

    @PostMapping
    public void agregarUsuario(
            @RequestBody Usuario usuario) {
        servicioUsuarios.agregarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(
            @PathVariable("id") int id) {
        var usuario = servicioUsuarios.obtenerUsuario(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(
            @PathVariable("id")int id, 
            @RequestBody Usuario nuevaInfoUsuario) {
        servicioUsuarios.actualizarUsuario(id, nuevaInfoUsuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(
            @PathVariable("id")int id) {
        servicioUsuarios.eliminarUsuario(id);
    }

    /*
    @PostMapping("/usuarios/crear") // Mala práctica
    public void crearUsuario(
            @RequestBody Usuario usuario) {
        servicioUsuarios.agregarUsuario(usuario);
    }
    */
}
