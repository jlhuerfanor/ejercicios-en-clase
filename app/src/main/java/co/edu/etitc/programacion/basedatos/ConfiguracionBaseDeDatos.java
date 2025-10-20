package co.edu.etitc.programacion.basedatos;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;


@Configuration
@EnableJdbcRepositories("co.edu.etitc.programacion.basedatos")
public class ConfiguracionBaseDeDatos extends AbstractJdbcConfiguration {
    
    @Bean
    @Primary
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:file:./test.db");
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) { 
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {                     
        return new DataSourceTransactionManager(dataSource);
    }
}
