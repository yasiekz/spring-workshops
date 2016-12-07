package app.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
public class TopStory
{
    @Id
    @JsonSerialize
    private ObjectId objectId;

    @JsonSerialize
    private Integer id;

    @JsonSerialize
    @Indexed
    private String title;

    @Reference
    @JsonSerialize
    private Video video;

    @Embedded
    @JsonSerialize
    private Photo photo;

    public TopStory() { }

    public TopStory(Integer id, String title, Video video, Photo photo)
    {
        this.id = id;
        this.title = title;
        this.video = video;
        this.photo = photo;
    }

    public Integer getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public TopStory setTitle(String title)
    {
        this.title = title;

        return this;
    }

    public Video getVideo()
    {
        return video;
    }

    public TopStory setVideo(Video video)
    {
        this.video = video;

        return this;
    }

    public Photo getPhoto()
    {
        return photo;
    }

    public TopStory setPhoto(Photo photo)
    {
        this.photo = photo;

        return this;
    }
}
