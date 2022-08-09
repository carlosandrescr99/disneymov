
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.services.VideoService;
import org.springframework.stereotype.Service;

@Service

public class VideoServiceImpl implements VideoService{
    public VideoDTO save (VideoDTO videodto){
        System.out.println("SAVE VIDEO");
        return videodto;
    
    }
    
}
