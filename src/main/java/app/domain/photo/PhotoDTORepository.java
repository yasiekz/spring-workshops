package app.domain.photo;

import app.domain.topStory.dto.TopStoryDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhotoDTORepository {
    public PhotoDTO getPhotoDTO(int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://json-spring/photo-" + id + ".json", PhotoDTO.class);
    }
}
