package app.client;

import app.dto.VideoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoClient
{
    public VideoDTO getById(Integer id)
    {
        RestTemplate template = new RestTemplate();
        String resourceUrl = "http://json-spring/video-" + id + ".json";

        return template.getForObject(resourceUrl, VideoDTO.class);
    }
}
