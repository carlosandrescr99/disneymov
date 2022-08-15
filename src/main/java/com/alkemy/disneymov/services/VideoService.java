
package com.alkemy.disneymov.services;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.dto.VideoDTO;
import java.util.List;


public interface VideoService {
    VideoDTO save (VideoDTO videodto);
    List<VideoDTO> getAllVideos();
    void delete(Long id);    
}
