package app.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
public class TopStory {
    @Id
    @JsonSerialize
    private ObjectId objectId;

    @JsonSerialize
    @Indexed
    private String title;

    @Reference
    @JsonSerialize
    private Video video;

    @Embedded
    @JsonSerialize
    private Photo photo;

    public TopStory() {
    }

    public TopStory(String title, Video video, Photo photo) {
        this.title = title;
        this.video = video;
        this.photo = photo;
    }

    public Video getVideo() {
        return video;
    }
}
