package co.edu.etitc.programacion.basedatos;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws SQLException {

        try(var contexto = new AnnotationConfigApplicationContext(ConfiguracionBaseDeDatos.class)) {
            DataSource dataSource = contexto.getBean(DataSource.class);
            Connection conexion = dataSource.getConnection();

            Statement statement = conexion.createStatement();
            statement.execute("CREATE TABLE USUARIO (id INTEGER PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR, apellido VARCHAR, edad INTEGER)");
            statement.close();
            
            conexion.close();

            UsuarioRepositorio repositorio = contexto.getBean(UsuarioRepositorio.class);
            
            Usuario usuario = new Usuario();
            usuario.setNombre("Pepito");
            usuario.setApellido("Perez");
            usuario.setEdad(25);

            repositorio.save(usuario);
            for(var us : repositorio.findAll()) {
                System.out.println("id: " + us.getId() + ", Nombre: " + us.getNombre() + ", Apellido: " + us.getApellido() + ", Edad: " + us.getEdad());
            }
        }
    }
    
}
