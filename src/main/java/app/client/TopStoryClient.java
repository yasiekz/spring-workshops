package app.client;

import app.dto.TopStoryDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopStoryClient
{
    public TopStoryDTO getById(Integer id)
    {
        RestTemplate template = new RestTemplate();
        String resourceUrl = "http://json-spring/top-story" + id + ".json";

        return template.getForObject(resourceUrl, TopStoryDTO.class);
    }
}
