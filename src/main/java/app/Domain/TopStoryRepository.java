package app.Domain;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopStoryRepository {
    @Autowired
    private Datastore datastore;

    public TopStoryRepository(Datastore datastore) {
        this.datastore = datastore;
    }

    public void save(TopStory topStory)
    {
        this.datastore.save(topStory);
    }
}