
package com.alkemy.disneymov.mapper;

import com.alkemy.disneymov.dto.GenreDTO;
import com.alkemy.disneymov.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    
    public Genre genreDTO2Genre(GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setImage(genreDTO.getImage());
        return genre;
    }
    
    public GenreDTO Genre2genreDTO(Genre genre){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setImage(genre.getImage());
        return genreDTO;
    } 
   
    public List<GenreDTO> genreList2genreDTOList(List<Genre> genres){
        List<GenreDTO> genreDTOs = new ArrayList<>();
        for (Genre genre : genres){
            genreDTOs.add(this.Genre2genreDTO(genre));
        }
        return genreDTOs;
    }
   
}
