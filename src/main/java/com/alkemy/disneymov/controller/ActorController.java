package com.alkemy.disneymov.controller;

import com.alkemy.disneymov.dto.ActorDTO;
//import com.alkemy.disneymov.repository.ActorRepository;
import com.alkemy.disneymov.services.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//import java.util.Set;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("epactors")

public class ActorController {
    
    @Autowired
    private ActorService actorService;

    
    @PostMapping 
    public ResponseEntity <ActorDTO> save(@RequestBody ActorDTO actor){
        ActorDTO actorSaved = actorService.save(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorSaved);    

    }
    
    
    @GetMapping
    public ResponseEntity <List<ActorDTO>> getAll() {
        List<ActorDTO> actors =actorService.getAllActors();
        return ResponseEntity.ok().body(actors);
    }

//    @GetMapping
//    public ResponseEntity<List<ActorDTO>> getDetailsByFilters(
//            @RequestParam(required=false) String name,
//            @RequestParam(required=false) String birth,
//            @RequestParam(required=false) Set<Long> actors,
//            @RequestParam(required=false, defaultValue = "ASC") String order
//    ){
//        List <ActorDTO> actorDTOs = this.actorService.getByFilters(name, birth, actors, order);
//        return ResponseEntity.ok(actorDTOs);
//    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Long id){
        ActorDTO actorDTO = actorService.findActorById(id);
        return ResponseEntity.ok().body(actorDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById (@RequestBody ActorDTO actorDTO,@PathVariable Long id){
        ActorDTO actorDTOFound = actorService.findActorById(id);
        ActorDTO result = actorService.update(actorDTO, actorDTOFound);
        actorService.save(result);
        return new ResponseEntity<ActorDTO>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete( @PathVariable Long id){
        this.actorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}
