package app.Domain.topStory.dto;

import app.Domain.topStory.TitleSize;
import app.Domain.topStory.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopStoryDTO {
    public int id;
    public String title;
    public String lead;
    public Integer photo;
    public Integer video;
    public Integer article;
    public Integer additionalResource;
    public TitleSize titleSize;
    public Type type;
}
