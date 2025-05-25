package co.edu.etitc.programacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping(
        path = "/usuarios",
        produces = "application/json"
        )
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @PostMapping(path = "/usuarios")
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
    }

    @GetMapping(path = "/usuarios/{nombre}")
    public ResponseEntity<Usuario> obteneUsuario(
        @PathVariable("nombre") String nombre
    ) {
        return usuarios.stream()
            .filter(usuario -> usuario.getNombre().equals(nombre))
            .findFirst()
            .map(usuario -> ResponseEntity.ok().body(usuario))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/usuarios/{nombre}/edad")
    public Integer obteneEdadUsuario(
        @PathVariable("nombre") String nombre
    ) {
        return usuarios.stream()
            .filter(usuario -> usuario.getNombre().equals(nombre))
            .findFirst()
            .map(usuario -> usuario.getEdad()) // Lambda
            .orElseThrow();
    }
}
