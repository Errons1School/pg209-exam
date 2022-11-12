package no.kristiania.socialbuzz.db;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {

    public static HikariDataSource getDataSource() throws IOException {
        var properties = new Properties();
        var dataSource = new HikariDataSource();

        FileReader reader = new FileReader("application.properties");
        try (reader) {
            properties.load(reader);
            dataSource.setAutoCommit(false);
            dataSource.setJdbcUrl(System.getenv("DB_URL"));
            dataSource.setUsername(System.getenv("DB_USER"));
            dataSource.setPassword(System.getenv("DB_PASSWORD"));

        }
        var flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();

/*
            dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
*/
        return dataSource;
    }
}
