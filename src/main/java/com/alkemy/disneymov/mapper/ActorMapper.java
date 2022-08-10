
package com.alkemy.disneymov.mapper;

import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.entity.Actor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {
    
    public Actor actorDTO2Actor(ActorDTO actorDTO){
        Actor actor = new Actor();
        actor.setName(actorDTO.getName());
        actor.setImage(actorDTO.getImage());
        actor.setBirth(actorDTO.getBirth());
        actor.setWeight(actorDTO.getWeight());
        actor.setStory(actorDTO.getStory());
        
        return actor;
    }

    public ActorDTO Actor2actorDTO(Actor actor){
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
            actorDTOs.add(this.Actor2actorDTO(actor));
        }
        return actorDTOs;
    }
   
}
