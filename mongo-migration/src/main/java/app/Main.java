package app;

import com.mongodb.client.model.Indexes;
import core.framework.mongo.MongoMigration;
import org.bson.Document;

/**
 * @author steve
 */
public class Main {
    public static void main(String[] args) {
        MongoMigration initMigration = new MongoMigration("sys.properties", "sys.mongo.uri");
        initMigration.migrate(mongo -> {
            mongo.runCommand(new Document().append("setParameter", 1).append("notablescan", 1));
        });

        MongoMigration createMigration = new MongoMigration("sys.properties");
        createMigration.migrate(mongo -> {
            mongo.createIndex("test", Indexes.ascending("name"));
        });
    }
}
