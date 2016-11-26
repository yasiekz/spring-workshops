package app.controller;

import app.domain.NotFoundException;
import app.domain.topStory.TopStory;
import app.domain.topStory.TopStoryRepository;
import app.domain.topStory.builder.TopStoryBuilder;
import app.domain.topStory.dto.TopStoryDTO;
import app.domain.topStory.dto.TopStoryDTORepository;
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
    TopStoryBuilder topStoryBuilder;

    @Autowired
    public TopStoryController(TopStoryRepository topStoryRepository, TopStoryDTORepository topStoryDTORepository, TopStoryBuilder topStoryBuilder) {
        this.topStoryRepository = topStoryRepository;
        this.topStoryDTORepository = topStoryDTORepository;
        this.topStoryBuilder = topStoryBuilder;
    }

    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public String refresh(@PathVariable int id) {

        TopStoryDTO topStoryDTO = this.topStoryDTORepository.getTopStoryDTO(id);
        TopStory topStory;

        try {
            TopStory oldTopStory = this.topStoryRepository.findOne(id);
            topStory = this.topStoryBuilder.build(oldTopStory.getObjectId(), topStoryDTO);
        } catch (NotFoundException e) {
            topStory = this.topStoryBuilder.build(topStoryDTO);
        }

        this.topStoryRepository.save(topStory);

        Gson gson = new GsonBuilder().create();
        return gson.toJson(topStory);
    }

    @RequestMapping(value = "/get/{id:\\d+}", produces = "application/json")
    public String get(@PathVariable int id) throws NotFoundException {

        TopStory topStory = this.topStoryRepository.findOne(id);
            Gson gson = new GsonBuilder().create();
        return gson.toJson(topStory);
    }


}