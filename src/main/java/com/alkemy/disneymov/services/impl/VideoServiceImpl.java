
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.entity.Video;
import com.alkemy.disneymov.mapper.VideoMapper;
import com.alkemy.disneymov.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.disneymov.repository.VideoRepository;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoRepository videoRepository;

    public VideoDTO save(VideoDTO videoDTO){
        Video video = videoMapper.videoDTO2Video(videoDTO);
        Video videoSaved = videoRepository.save(video);
        VideoDTO result = videoMapper.Video2videoDTO(videoSaved);
        return result;
    }
    
    public List<VideoDTO> getAllVideos() {
        List<Video> videos = videoRepository.findAll();
        List<VideoDTO> result = videoMapper.videoList2videoDTOList(videos);
        return result;
    }
    
    public void delete(Long id){
        this.videoRepository.deleteById(id);
    }
}
