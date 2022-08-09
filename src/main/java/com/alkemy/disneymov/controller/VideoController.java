
package com.alkemy.disneymov.controller;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
   @PostMapping 
   public ResponseEntity <VideoDTO> save(@RequestBody VideoDTO video){
       // TODO: save video
       VideoDTO videoSaved = videoService.save(video);
       return ResponseEntity.status(HttpStatus.CREATED).body(videoSaved);
   
   } 
    
}
