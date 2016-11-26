package app.Domain.topStory.dto;

import app.Domain.topStory.TitleSize;
import app.Domain.topStory.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopStoryDTO {
    public int id;
    public String title;
    public String lead;
    public int photo;
    public int video;
    public int article;
    public int additionalResource;
    public TitleSize titleSize;
    public Type type;
}
