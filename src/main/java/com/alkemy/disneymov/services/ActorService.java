
package com.alkemy.disneymov.services;

import com.alkemy.disneymov.dto.ActorDTO;
import java.util.List;

public interface ActorService {
    ActorDTO save (ActorDTO actordto);
    List<ActorDTO> getAllActors();
    void delete(Long id);
}  