package app.domain.topStory;

import app.domain.NotFoundException;
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

    public TopStory findOne(int id) throws NotFoundException {
        TopStory topStory = datastore.find(TopStory.class).field("id").equal(id).get();

        if (topStory == null) {
            throw new NotFoundException("Object with ID = " + id + " not found");
        }

        return topStory;
    }
}