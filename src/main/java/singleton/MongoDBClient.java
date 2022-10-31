package singleton;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class MongoDBClient {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBClient.class);

    public static MongoDBClient client = null;
    public MongoClient mongoClient;

    private MongoDBClient() {
        this.initializeMongoDbClient();
    }

    private void initializeMongoDbClient() {
        try {
            logger.info("Initializing the mongoDb client!!");
            this.mongoClient = MongoClients.create("mongodb://root:secret@127.0.0.1:27017");
            logger.info("Mysql Client was connected successfully");
        } catch (MongoException me) {
            logger.error("Error while connecting to Mongo DB");
            me.printStackTrace();
        }
    }

    public static MongoDBClient getClient() {
        if (Objects.isNull(client)) {
            client = new MongoDBClient();
        }

        return client;
    }



    public long getData() {
        return this.mongoClient.getDatabase("bootcampDb").getCollection("bootcamp").countDocuments();
    }
}
