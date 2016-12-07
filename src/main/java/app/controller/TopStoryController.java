package app.controller;

import app.client.PhotoClient;
import app.client.TopStoryClient;
import app.client.VideoClient;
import app.domain.Photo;
import app.domain.TopStory;
import app.domain.Video;
import app.dto.PhotoDTO;
import app.dto.TopStoryDTO;
import app.dto.VideoDTO;
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

    @Autowired
    private VideoClient videoClient;

    @Autowired
    private PhotoClient photoClient;

    @RequestMapping(value = "/refresh/{id:\\d+}", produces = "application/json")
    public TopStory refresh(@PathVariable int id)
    {
        TopStoryDTO topStoryDTO = topStoryClient.getById(id);
        PhotoDTO photoDTO = photoClient.getById(topStoryDTO.photoId);

        Video video = null;
        if (topStoryDTO.videoId != null) {
            VideoDTO videoDTO = videoClient.getById(topStoryDTO.videoId);
            video = new Video(videoDTO.title);
        }

        Photo photo = new Photo(photoDTO.title);

        TopStory topStory = repository.getById(id);
        if (topStory != null) {
            topStory
                .setPhoto(photo)
                .setVideo(video)
                .setTitle(topStoryDTO.title);
        } else {
            topStory = new TopStory(
                id,
                topStoryDTO.title,
                video,
                photo
            );
        }

        repository.save(topStory);

        return topStory;
    }

    @RequestMapping(value = "/topstory/{id:\\d+}", produces = "application/json")
    public TopStoryDTO getTopStory(@PathVariable int id)
    {
        return topStoryClient.getById(id);
    }

    @RequestMapping(value = "/video/{id:\\d+}", produces = "application/json")
    public VideoDTO getVideo(@PathVariable int id)
    {
        return videoClient.getById(id);
    }

    @RequestMapping(value = "/photo/{id:\\d+}", produces = "application/json")
    public PhotoDTO getPhoto(@PathVariable int id)
    {
        return photoClient.getById(id);
    }
}