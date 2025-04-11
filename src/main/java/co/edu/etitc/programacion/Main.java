package co.edu.etitc.programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        try(var contexto = new AnnotationConfigApplicationContext(
            ConfiguracionAplicacion.class)) {

            try(Connection conexion  = DriverManager.getConnection("jdbc:h2:mem:test")) {
                conexion.setAutoCommit(false);
                
                crearTablas(conexion);
                insertUsandoStatement(conexion);
                insertUsandoStatementConRollback(conexion);
                insertUsandoPreparedStatement(conexion);
            }
        } 
    }

    private static void insertUsandoPreparedStatement(Connection conexion) throws SQLException {
        PreparedStatement preparedStatement = conexion.prepareStatement("""
            INSERT INTO usuario(nombre, apellido, edad, correo) 
            VALUES (?, ?, ?, ?)
        """);

        preparedStatement.setString(1, "Carlitos");
        preparedStatement.setString(2, "Martinez");
        preparedStatement.setInt(3, 23);
        preparedStatement.setString(4, "no@malicioso.com");
        preparedStatement.executeUpdate();
        conexion.commit();

        imprimirUsuario(conexion);
    }

    private static void insertUsandoStatementConRollback(Connection conexion) throws SQLException {
        conexion.createStatement().execute("""
            INSERT INTO usuario(nombre, apellido, edad, correo) 
            VALUES ('Juanito', 'Perez', 22, 'correo@malicioso.com')
        """);

        imprimirUsuario(conexion);

        conexion.rollback();

        imprimirUsuario(conexion);
    }

    private static void insertUsandoStatement(Connection conexion) throws SQLException {
        conexion.createStatement().execute("""
            INSERT INTO usuario(nombre, apellido, edad, correo) 
            VALUES ('Juanito', 'Perez', 22, 'correo@malicioso.com')
        """);

        imprimirUsuario(conexion);

        conexion.commit();
    }

    private static void crearTablas(Connection conexion) throws SQLException {
        conexion.createStatement().execute("""
                    CREATE TABLE usuario(
                        id int not null generated always as identity,
                        nombre text,
                        apellido text,
                        edad int,
                        correo text)
                """);
        conexion.commit();
    }

    private static void imprimirUsuario(Connection conexion) throws SQLException {
        ResultSet resultado = conexion.createStatement().executeQuery("""
            SELECT 
                id,
                CONCAT(nombre, ' ', apellido) as nombreCompleto,
                edad,
                correo as email
            FROM usuario
        """);

        while (resultado.next()) {
            System.out.printf("id: %d, nombre: %s, edad: %d, email: %s%n", 
                resultado.getInt(1),
                resultado.getString("nombreCompleto"),
                resultado.getInt("edad"),
                resultado.getString("email"));   
        }

        System.err.printf("%n---%n%n");
    }
}