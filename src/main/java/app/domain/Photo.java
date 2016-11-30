package app.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Photo {
    @JsonSerialize
    private String title;

    public Photo() {
    }

    public Photo(String title) {
        this.title = title;
    }
}
