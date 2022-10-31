package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonMain {

    private static final Logger logger = LoggerFactory.getLogger(SingletonMain.class);
    public static void main(String[]arg){
        MongoDBClient mongoDBClient = MongoDBClient.getClient();
        logger.info("mongo data: {}", mongoDBClient.getData());
        MongoDBClient mongoDBClient2 = MongoDBClient.getClient();
        logger.info("mongo data2: {}", mongoDBClient2.getData());

        MySqlDBClient mySqlDBClient = MySqlDBClient.getClient();
        logger.info("mysql data: {}", mySqlDBClient.getData());

        MySqlDBClient mySqlDBClient2 = MySqlDBClient.getClient();
        logger.info("mysql data2: {}", mySqlDBClient2.getData());
    }
}
