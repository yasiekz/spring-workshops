package app.Domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class TopStory {
    @Id
    private ObjectId id;
    @Property
    private String title;

    public TopStory() {}

    public TopStory(String title)
    {
        this.title = title;
    }
}
