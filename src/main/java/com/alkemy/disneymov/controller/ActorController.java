
package com.alkemy.disneymov.controller;

import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("epactors")

public class ActorController {
    
    @Autowired
    private ActorService actorService;
    
    @PostMapping 
    public ResponseEntity <ActorDTO> save(@RequestBody ActorDTO actor){
        // TODO: save actor
        ActorDTO actorSaved = actorService.save(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorSaved);    

    }
}
