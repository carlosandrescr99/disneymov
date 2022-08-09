
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.services.ActorService;
import com.alkemy.disneymov.dto.ActorDTO;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{
            public ActorDTO save (ActorDTO actordto){
        //save
        System.out.println("SAVE ACTOR");
        return actordto;
    
    }
}
