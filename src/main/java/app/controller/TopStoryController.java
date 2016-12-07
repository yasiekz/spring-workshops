package app.controller;

import app.client.TopStoryClient;
import app.domain.TopStory;
import app.dto.TopStoryDTO;
import app.repository.TopStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopStoryController
{
    @Autowired
    private TopStoryRepository repository;

    @Autowired
    private TopStoryClient topStoryClient;

    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public List<TopStory> refresh(@PathVariable int id)
    {
        return repository.getByVideoId("photo2");
    }

    @RequestMapping(value = "/topstory/{id:\\d+}", produces = "application/json")
    public TopStoryDTO getTopStory(@PathVariable int id)
    {
        return topStoryClient.getById(id);
    }
}