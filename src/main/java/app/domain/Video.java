package app.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Video {
    @Id
    @JsonSerialize
    private ObjectId objectId;

    @JsonSerialize
    private String title;

    public Video() {
    }

    public Video(String title) {
        this.title = title;
    }
}
