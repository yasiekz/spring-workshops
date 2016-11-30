package app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopStoryController {
    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public String refresh(@PathVariable int id) {
        return "dupa";
    }
}