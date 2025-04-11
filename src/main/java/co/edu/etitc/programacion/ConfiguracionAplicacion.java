package co.edu.etitc.programacion;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@ComponentScan("co.edu.etitc.programacion")
@EnableJdbcRepositories(basePackages = "co.edu.etitc.programacion")
public class ConfiguracionAplicacion {
    @Bean
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();

        dataSource.setUrl("jdbc:h2:file:./db-ejercicio");

        return dataSource;
    }
}
