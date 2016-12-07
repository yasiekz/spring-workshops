package app.client;

import app.dto.PhotoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhotoClient
{
    public PhotoDTO getById(Integer id)
    {
        RestTemplate template = new RestTemplate();
        String resourceUrl = "http://json-spring/top-story" + id + ".json";

        return template.getForObject(resourceUrl, PhotoDTO.class);
    }
}
