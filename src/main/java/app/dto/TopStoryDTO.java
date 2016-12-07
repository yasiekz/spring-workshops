package app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopStoryDTO
{
    public Integer id;

    public String title;

    public String lead;

    @JsonProperty("photo")
    public Integer photoId;

    @JsonProperty("video")
    public Integer videoId;

    @JsonProperty("title_size")
    public String titleSize;

    public String type;

    @JsonProperty("article")
    public Integer articleId;
}
