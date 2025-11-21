package co.edu.etitc.programacion.web.servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import co.edu.etitc.programacion.web.modelo.Usuario;

@Service
public class ServicioUsuarios {
    private List<Usuario> usuarios;

    public ServicioUsuarios() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        int indice = usuarios.size();

        usuario = new Usuario(indice + 1, usuario.getNombre(), usuario.getApellido(), usuario.getEdad());
        usuarios.add(usuario);
    }

    public void eliminarUsuario(int idUsuario) {
        var usuario = usuarios.stream()
            .filter(u -> u.getId() == idUsuario)
            .findFirst();

        if (usuario.isPresent()) {
            usuarios.remove(usuario.get());
        }
    }

    public Usuario obtenerUsuario(int idUsuario) {
        return usuarios.stream()
            .filter(u -> u.getId() == idUsuario)
            .findFirst()
            .orElse(null);
    }

    public void actualizarUsuario(int idUsuario, Usuario nuevaInfoUsuario) {
        var usuarioActual = obtenerUsuario(idUsuario);

        if (usuarioActual != null) {
            usuarioActual = new Usuario(idUsuario, 
                nuevaInfoUsuario.getNombre(), 
                nuevaInfoUsuario.getApellido(), 
                nuevaInfoUsuario.getEdad());

            eliminarUsuario(idUsuario);
            usuarios.add(usuarioActual);
        }
    }
    
}
