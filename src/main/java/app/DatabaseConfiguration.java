package app;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
public class DatabaseConfiguration {

    private static final String host = "127.0.0.1";
    private static final String port = "27017";
    private static final String dbname = "java-workshops";

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return (new MongoClient(host+":"+port));
    }

    @Bean(name = "dataStore")
    public Datastore datastore() throws UnknownHostException {
        Morphia morphia = new Morphia();
//        morphia.map(TopStory.class);
        Datastore datastore = morphia.createDatastore(mongoClient(), dbname);
        datastore.ensureIndexes();
        return datastore;
    }
}
