package app.domain.video;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("video")
public class VideoDTO {
    @Id
    public ObjectId objectId;
    public int id;
    public String title;
    public String url;
}
