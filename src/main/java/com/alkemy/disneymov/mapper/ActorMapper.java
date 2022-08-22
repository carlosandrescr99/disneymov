
package com.alkemy.disneymov.mapper;

import com.alkemy.disneymov.dto.ActorBasicDTO;
import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.dto.VideoDTO;
import com.alkemy.disneymov.entity.Actor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {
    @Autowired
    private VideoMapper videoMapper;
    public Actor actorDTO2Actor(ActorDTO actorDTO){
        Actor actor = new Actor();
        actor.setId(actorDTO.getId());
        actor.setName(actorDTO.getName());
        actor.setImage(actorDTO.getImage());
        actor.setBirth(actorDTO.getBirth());
        actor.setWeight(actorDTO.getWeight());
        actor.setStory(actorDTO.getStory());
        
        return actor;
    }

    public ActorDTO actor2actorDTO(Actor actor){
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(actor.getId());
        actorDTO.setName(actor.getName());
        actorDTO.setImage(actor.getImage());
        actorDTO.setBirth(actor.getBirth());
        actorDTO.setWeight(actor.getWeight());
        actorDTO.setStory(actor.getStory());
        return actorDTO;
    } 
   
    public List<ActorDTO> actorList2actorDTOList(List<Actor> actors){
        List<ActorDTO> actorDTOs = new ArrayList<>();
        for (Actor actor : actors){
            actorDTOs.add(this.actor2actorDTO(actor));
        }
        return actorDTOs;
    }
   
//    public ActorDTO Actor2actorDTO(Actor actor, boolean loadVideos){
//        ActorDTO actorDTO = new ActorDTO();
//        actorDTO.setId(actor.getId());
//        actorDTO.setName(actor.getName());
//        actorDTO.setImage(actor.getImage());
//        actorDTO.setBirth(actor.getBirth());
//        actorDTO.setWeight(actor.getWeight());
//        actorDTO.setStory(actor.getStory());
//        if (loadVideos){
//            
//            List<VideoDTO> videoDTOs = this.videoMapper.videoList2videoDTOList(actor.getVideos(), loadVideos=false);                  
//        }
//        return actorDTO;
//    }

    
    public Set<Actor> actorDTOList2Actor (List<ActorDTO> actorDTOs){
        Set<Actor> actors = new HashSet<>();
        for (ActorDTO actorDTO : actorDTOs){
            actors.add(this.actorDTO2Actor(actorDTO));
        }        
        return actors;
    }
 
//    public List<ActorDTO> actor2ActorDTOList(Collection<Actor> actors, boolean loadVideos){
//        List<ActorDTO> actorDTOs = new ArrayList<>();
//        for (Actor actor : actors){
//            actorDTOs.add(this.Actor2actorDTO(actor, loadVideos));
//        }
//        return actorDTOs;        
//    }    
   
    
    public List<ActorBasicDTO> actor2ActorBasicDTOList(Collection<Actor> actors){
        List<ActorBasicDTO> actorBasicDTOs = new ArrayList<>();
        ActorBasicDTO actorBasicDTO;
        for (Actor actor : actors){
        actorBasicDTO = new ActorBasicDTO();
        actorBasicDTO.setId(actor.getId());
        actorBasicDTO.setImage(actor.getImage());
        actorBasicDTO.setName(actor.getName());
        }        
        return actorBasicDTOs;
        
    }
}
