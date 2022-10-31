package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


/**
 * MySqlDBClient class.
 *
 * @since 2022/10/30
 */
public class MySqlDBClient {

    private static final Logger logger = LoggerFactory.getLogger(MySqlDBClient.class);

    public static MySqlDBClient client = null;
    private Connection connection;

    /**
     * Builds an instance of {@link MySqlDBClient}.
     */
    private MySqlDBClient() {
        this.initializeMysqlDbClient();
    }

    /**
     * Initialize the Mysql DB client.
     */
    private void initializeMysqlDbClient() {
        try {
            logger.info("Initializing the mysql client!!");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcampDb", "root", "secret");
            logger.info("Mysql Client was connected successfully");
        } catch (SQLException e) {
            logger.error("Error while connecting to MYSQL");
        }
    }

    /**
     * Gets the client.
     *
     * @return The client
     */
    public static MySqlDBClient getClient() {
        if (Objects.isNull(client)) {
            client = new MySqlDBClient();
        }

        return client;
    }

    /**
     * Gets the data (Returns the current timestamp).
     *
     * @return The data
     */
    public long getData() {
        long timestamp = 0;
        try {
            Statement stmt = this.connection.createStatement();
            String query = "SELECT UNIX_TIMESTAMP(NOW(3))*1000 AS TIMESTAMP";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                timestamp = rs.getLong("TIMESTAMP");
                logger.info("TIMESTAMP: {}", timestamp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return timestamp;
    }
}
