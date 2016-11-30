package app.repository;

import app.domain.TopStory;
import app.domain.Video;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopStoryRepository
{
    @Autowired
    private Datastore datastore;

    @Autowired
    private VideoRepository videoRepository;

    public void save(TopStory topStory)
    {
        videoRepository.save(topStory.getVideo());
        datastore.save(topStory);
    }

    public TopStory findById(ObjectId topStoryId)
    {
        return datastore.find(TopStory.class)
            .field("objectId")
            .equal(topStoryId)
            .get();
    }

    public List<TopStory> getAll()
    {
        return datastore
            .find(TopStory.class)
            .limit(2)
            .order("-objectId")
            .asList();
    }

    public List<TopStory> getByVideoId(String videoTitle)
    {
        return datastore.find(TopStory.class)
            .field("photo.title")
            .equal(videoTitle)
            .asList();
    }
}
