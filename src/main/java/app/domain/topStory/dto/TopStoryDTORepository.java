package app.domain.topStory.dto;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopStoryDTORepository {
    public TopStoryDTO getTopStoryDTO(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://json-spring/top-story" + id + ".json", TopStoryDTO.class);
    }
}
