
package com.alkemy.disneymov.mapper;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.entity.Video;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {
    
    public Video videoDTO2Video(VideoDTO videoDTO){
        Video video = new Video();
        video.setTitle(videoDTO.getTitle());
        video.setImage(videoDTO.getImage());
        video.setRating(videoDTO.getRating());
        video.setDateCreated(videoDTO.getDateCreated());
        video.setIdgenre(videoDTO.getIdgenre());
        return video;
    }
    
//    private String title;
//    private String image;
//    private Integer rating;
//    private LocalDate dateCreated;
//    private int idgenre;
//    private Boolean deleted;
    
    public VideoDTO Video2videoDTO(Video video){
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId(video.getId());
        videoDTO.setTitle(video.getTitle());
        videoDTO.setImage(video.getImage());
        videoDTO.setRating(video.getRating());
        videoDTO.setDateCreated(video.getDateCreated());
        videoDTO.setIdgenre(video.getIdgenre());
        return videoDTO;
    } 
   
    public List<VideoDTO> videoList2videoDTOList(List<Video> videos){
        List<VideoDTO> videoDTOs = new ArrayList<>();
        for (Video video : videos){
            videoDTOs.add(this.Video2videoDTO(video));
        }
        return videoDTOs;
    }
   
}
