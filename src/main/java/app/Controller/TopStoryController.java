package app.Controller;

import app.Domain.TopStory;
import app.Domain.TopStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopStoryController {
    TopStoryRepository topStoryRepository;

    @Autowired
    public TopStoryController(TopStoryRepository topStoryRepository) {
        this.topStoryRepository = topStoryRepository;
    }

    @RequestMapping(value = "/test/{id:\\d+}")
    public int test(@PathVariable int id) {

        TopStory topStory = new TopStory("test");

        this.topStoryRepository.save(topStory);

        return id;
    }
}