
package com.alkemy.disneymov.mapper;

import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.entity.Video;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {
    
//    @Autowired
//    ActorMapper actorMapper;
    
    public Video videoDTO2Video(VideoDTO videoDTO){
        Video video = new Video();
        video.setTitle(videoDTO.getTitle());
        video.setImage(videoDTO.getImage());
        video.setRating(videoDTO.getRating());
        video.setDateCreated(videoDTO.getDateCreated());
        video.setIdgenre(videoDTO.getIdgenre());
        return video;
    }   
    
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
    
//        public VideoDTO Video2VideoDTO(Video video, boolean loadActors){
//        VideoDTO videoDTO = new VideoDTO();
//        videoDTO.setId(video.getId());
//        videoDTO.setTitle(video.getTitle());
//        videoDTO.setImage(video.getImage());
//        videoDTO.setRating(video.getRating());
//        videoDTO.setDateCreated(video.getDateCreated());
//        videoDTO.setIdgenre(video.getIdgenre());
//        if(loadActors){
//            List<ActorDTO> actorDTOs = this.actorMapper.actor2ActorDTOList(video.getActors(), loadActors=false);
//        }
//        return videoDTO;
//    }
   
    public List<VideoDTO> videoList2videoDTOList(List<Video> videos){
        List<VideoDTO> videoDTOs = new ArrayList<>();
        for (Video video : videos){
            videoDTOs.add(this.Video2videoDTO(video));
        }
        return videoDTOs;
    }
//    public List<VideoDTO> videoList2videoDTOList(List<Video> videos, boolean loadActor){
//        List<VideoDTO> videoDTOs = new ArrayList<>();
//        for (Video video : videos){
//            videoDTOs.add(this.Video2VideoDTO(video, loadActor));
//        }
//        return videoDTOs;
//    }
    
    
    public List<Video> videoDTOList2video(List<VideoDTO> videoDTOs){
        List<Video> videos = new ArrayList<>();
        for (VideoDTO videoDTO : videoDTOs){
            videos.add(this.videoDTO2Video(videoDTO));
        }
        return videos;
    }      
}
