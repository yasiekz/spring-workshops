package app.domain.topStory;

import app.domain.photo.PhotoDTO;
import app.domain.video.VideoDTO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class TopStory {
    @Id
    private ObjectId objectId;
    @Property
    private int id;
    @Property
    private String title;
    @Property
    private String lead;
    private PhotoDTO photo;
    private VideoDTO video;
    @Property
    private TitleSize titleSize;

    public TopStory() {}

    public TopStory(int id, String title, String lead, PhotoDTO photo, VideoDTO video, TitleSize titleSize) {
        this.id = id;
        this.title = title;
        this.lead = lead;
        this.photo = photo;
        this.video = video;
        this.titleSize = titleSize;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public ObjectId getObjectId() {
        return objectId;
    }
}
