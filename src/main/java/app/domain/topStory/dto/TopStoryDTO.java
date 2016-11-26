package app.domain.topStory.dto;

import app.domain.topStory.TitleSize;
import app.domain.topStory.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopStoryDTO {
    public int id;
    public String title;
    public String lead;
    public int photo;
    public int video;
    @JsonProperty("title_size")
    public TitleSize titleSize;
}
