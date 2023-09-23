import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Database {

    public void init( ) {
        Properties properties = new Properties();
        try (InputStream resourceStream = getClass().getClassLoader().getResourceAsStream("hibernate.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String url = properties.getProperty("hibernate.connection.url");
        String username = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");


        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:~/test",
                        "sa",
                        "")
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();

    }
}
