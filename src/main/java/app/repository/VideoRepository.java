package app.repository;

import app.domain.Video;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoRepository {
    @Autowired
    private Datastore datastore;

    public void save(Video video)
    {
        datastore.save(video);
    }
}
