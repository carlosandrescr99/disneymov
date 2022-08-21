
package com.alkemy.disneymov.services;

import com.alkemy.disneymov.dto.ActorDTO;
import java.util.List;
import java.util.Set;

public interface ActorService {
    ActorDTO save (ActorDTO actordto);
    List<ActorDTO> getAllActors();
    void delete(Long id);
    ActorDTO findActorById(Long id);
//    List<ActorDTO> getByFilters(String name, String birth , Set<Long> videos, String order);
}  