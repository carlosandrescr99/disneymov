
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.services.ActorService;
import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.dto.ActorFiltersDTO;
import com.alkemy.disneymov.entity.Actor;
import com.alkemy.disneymov.mapper.ActorMapper;
import com.alkemy.disneymov.repository.ActorRepository;
import com.alkemy.disneymov.repository.specifications.ActorSpecification;
import com.alkemy.disneymov.services.VideoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImplem implements ActorService{
    
    @Autowired
    private ActorSpecification actorSpecification;
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private ActorRepository actorRepository;    
    @Autowired
    private VideoService videoService;
    

    public ActorDTO save (ActorDTO actorDTO){
        Actor actor = actorMapper.actorDTO2Actor(actorDTO);
        Actor actorSaved = actorRepository.save(actor);
        ActorDTO result = actorMapper.actor2actorDTO(actorSaved);
        return result;
        
    }
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = actorRepository.findAll();
        List<ActorDTO> result = actorMapper.actorList2actorDTOList(actors);
        return result;
    } 
    
    public ActorDTO findActorById(Long id) {
        Actor actor = actorRepository.findById(id).get();
        ActorDTO result = actorMapper.actor2actorDTO(actor);
        return result;
    } 
    
    public void delete(Long id){
        this.actorRepository.deleteById(id);
    }
    
    public List<ActorDTO> getByFilters(String name, String birth , Set<Long> videos, String order){
        ActorFiltersDTO actorFiltersDTO = new ActorFiltersDTO(name, birth , videos, order);
        List<Actor>  actors = this.actorRepository.findAll(this.actorSpecification.getByFilters(actorFiltersDTO));
        List<ActorDTO> actorDTOs = new ArrayList<>();
//       List<ActorDTO> actorDTOs = this.actorMapper.actor2ActorDTOList(actors, true);
        return actorDTOs;
    }




}




//        public ActorServiceImplem(
//          ActorRepository actorRepository,  
//          ActorSpecification actorSpecification,
//          ActorMapper actorMapper,
//          VideoService videoService){
//        this.actorRepository = actorRepository;
//        this.actorSpecification = actorSpecification;
//        this.actorMapper = actorMapper;
//        this.videoService = videoService;
//        }