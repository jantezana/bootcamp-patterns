package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SingletonMain class.
 *
 * @since 2022/10/30
 */
public class SingletonMain {

    private static final Logger logger = LoggerFactory.getLogger(SingletonMain.class);

    /**
     * Main method.
     *
     * @param arg The arguments
     */
    public static void main(String[] arg) {
        // Mongo DB Client.
        MongoDBClient mongoDBClient = MongoDBClient.getClient();
        logger.info("mongo data: {}", mongoDBClient.getData());
        MongoDBClient mongoDBClient2 = MongoDBClient.getClient();
        logger.info("mongo data2: {}", mongoDBClient2.getData());

        // Mysql DB Client.
        MySqlDBClient mySqlDBClient = MySqlDBClient.getClient();
        logger.info("mysql data: {}", mySqlDBClient.getData());
        MySqlDBClient mySqlDBClient2 = MySqlDBClient.getClient();
        logger.info("mysql data2: {}", mySqlDBClient2.getData());
    }
}
