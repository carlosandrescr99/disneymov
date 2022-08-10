
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.services.ActorService;
import com.alkemy.disneymov.dto.ActorDTO;
import com.alkemy.disneymov.entity.Actor;
import com.alkemy.disneymov.mapper.ActorMapper;
import com.alkemy.disneymov.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ActorServiceImpl implements ActorService{
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private ActorRepository actorRepository;
    public ActorDTO save (ActorDTO actorDTO){
        Actor actor = actorMapper.actorDTO2Actor(actorDTO);
        Actor actorSaved = actorRepository.save(actor);
        ActorDTO result = actorMapper.Actor2actorDTO(actorSaved);
        return result;
    }
}
