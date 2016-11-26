package app.domain.photo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("photo")
public class PhotoDTO {
    @Id
    public ObjectId objectId;
    public int id;
    public String title;
    public String url;
}
