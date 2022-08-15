
package com.alkemy.disneymov.controller;

import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.services.VideoService;
import com.alkemy.disneymov.services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("epvideos")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @GetMapping
    public ResponseEntity <List<VideoDTO>> getAll() {
        List<VideoDTO> videos =videoService.getAllVideos();
        return ResponseEntity.ok().body(videos);
    }

    
    @PostMapping 
    public ResponseEntity <VideoDTO> save(@RequestBody VideoDTO video){
        VideoDTO videoSaved = videoService.save(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(videoSaved);
   } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        this.videoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    

}
