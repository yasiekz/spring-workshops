package app.controller;

import app.domain.TopStory;
import app.repository.TopStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopStoryController {
    @Autowired
    private TopStoryRepository repository;

    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public List<TopStory> refresh(@PathVariable int id) {

        return repository.getByVideoId("photo2");
    }
}