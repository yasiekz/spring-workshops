package app.domain.video;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoDTORepository {
    public VideoDTO getVideoDTO(int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://json-spring/video-" + id + ".json", VideoDTO.class);
    }
}
