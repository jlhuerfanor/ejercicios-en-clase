package co.edu.etitc.programacion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        try(ConfigurableApplicationContext contexto = SpringApplication.run(Main.class, args)) {
            DataSource dataSource = contexto.getBean(DataSource.class);

            try(Connection connection = dataSource.getConnection()) {
                crearTablas(connection);
            }

            UsuarioRepositorio repositorio = contexto.getBean(UsuarioRepositorio.class);
            
            for (Usuario usuarioEnDB : repositorio.obtenerMayoresQueEdad(30)) {
                System.out.println(usuarioEnDB);
            }
        }
    }

    private static void crearTablas(Connection conexion) throws SQLException {
        conexion.createStatement().execute("""
            CREATE TABLE IF NOT EXISTS usuario(
                id int not null generated always as identity,
                nombre text,
                apellido text,
                edad int,
                correo text)
        """);
        conexion.commit();
    }
}