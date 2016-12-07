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
        Video video = topStory.getVideo();
        if (video != null) {
            videoRepository.save(video);
        }
        datastore.save(topStory);
    }

    public TopStory getById(Integer id)
    {
        return datastore.find(TopStory.class)
            .field("id")
            .equal(id)
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
