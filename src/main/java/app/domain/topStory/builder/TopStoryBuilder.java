package app.domain.topStory.builder;

import app.domain.photo.PhotoDTO;
import app.domain.photo.PhotoDTORepository;
import app.domain.topStory.TopStory;
import app.domain.topStory.dto.TopStoryDTO;
import app.domain.video.VideoDTO;
import app.domain.video.VideoDTORepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class TopStoryBuilder {

    private PhotoDTORepository photoDTORepository;
    private VideoDTORepository videoDTORepository;

    public TopStoryBuilder(PhotoDTORepository photoDTORepository, VideoDTORepository videoDTORepository) {
        this.photoDTORepository = photoDTORepository;
        this.videoDTORepository = videoDTORepository;
    }

    public TopStory build(TopStoryDTO topStoryDTO) {
        VideoDTO videoDTO = this.getVideo(topStoryDTO.video);
        PhotoDTO photoDTO = this.getPhoto(topStoryDTO.photo);

        return new TopStory(
                topStoryDTO.id,
                topStoryDTO.title,
                topStoryDTO.lead,
                photoDTO,
                videoDTO,
                topStoryDTO.titleSize
        );
    }

    public TopStory build(ObjectId objectId, TopStoryDTO topStoryDTO)
    {
        TopStory topStory = this.build(topStoryDTO);
        topStory.setObjectId(objectId);
        return topStory;
    }

    private VideoDTO getVideo(int id)
    {
        if(id > 0) {
            return this.videoDTORepository.getVideoDTO(id);
        }

        return null;
    }

    private PhotoDTO getPhoto(int id)
    {
        if(id > 0) {
            return this.photoDTORepository.getPhotoDTO(id);
        }

        return null;
    }
}
