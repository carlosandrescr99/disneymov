
package com.alkemy.disneymov.services;

import com.alkemy.disneymov.dto.GenreDTO;
import java.util.List;


public interface GenreService {
    GenreDTO save (GenreDTO genredto);
    List<GenreDTO> getAllGenres();
    void delete(Long id);    
}
