package app.Controller;

import app.Domain.topStory.TopStory;
import app.Domain.topStory.TopStoryRepository;
import app.Domain.topStory.dto.TopStoryDTO;
import app.Domain.topStory.dto.TopStoryDTORepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopStoryController {
    TopStoryRepository topStoryRepository;
    TopStoryDTORepository topStoryDTORepository;

    @Autowired
    public TopStoryController(TopStoryRepository topStoryRepository, TopStoryDTORepository topStoryDTORepository) {
        this.topStoryRepository = topStoryRepository;
        this.topStoryDTORepository = topStoryDTORepository;
    }

    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public String refresh(@PathVariable int id) {

        TopStoryDTO topStoryDTO = this.topStoryDTORepository.getTopStoryDTO(id);
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(topStoryDTO);
    }
}