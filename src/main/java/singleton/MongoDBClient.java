package singleton;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


/**
 * MongoDBClient class
 *
 * @since 2022/10/30
 */
public class MongoDBClient {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBClient.class);

    public static MongoDBClient client = null;
    public MongoClient mongoClient;

    /**
     * Creates an instance of {@link MongoDBClient}.
     */
    private MongoDBClient() {
        this.initializeMongoDbClient();
    }

    /**
     * Initialize the mongo db client
     */
    private void initializeMongoDbClient() {
        try {
            logger.info("Initializing the mongoDb client!!");
            this.mongoClient = MongoClients.create("mongodb://root:secret@127.0.0.1:27017");
            logger.info("Mongo Client was connected successfully");
        } catch (MongoException me) {
            logger.error("Error while connecting to Mongo DB");
            me.printStackTrace();
        }
    }

    /**
     * Gets the client.
     *
     * @return The client
     */
    public static MongoDBClient getClient() {
        if (Objects.isNull(client)) {
            client = new MongoDBClient();
        }

        return client;
    }

    /**
     * Gets the data (Returns the number of document for the collection bootcamp)
     *
     * @return The data
     */
    public long getData() {
        return this.mongoClient.getDatabase("bootcampDb").getCollection("bootcamp").countDocuments();
    }
}
