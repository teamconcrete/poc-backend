package br.com.concrete.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DBUnitConfig {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "dbUnitDatabaseConnection")
    public DataSource getDbUnitDatabaseConnection() {
        return dataSource;
    }
}
