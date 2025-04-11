package co.edu.etitc.programacion;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    @Query("""
        SELECT * FROM USUARIO WHERE EDAD > :edadParametro
    """)
    List<Usuario> obtenerMayoresQueEdad(
        @Param("edadParametro") Integer edad);
}
