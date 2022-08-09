
package com.alkemy.disneymov.services.impl;

import com.alkemy.disneymov.dto.GenreDTO;
import com.alkemy.disneymov.entity.Genre;
import com.alkemy.disneymov.mapper.GenreMapper;
import com.alkemy.disneymov.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.disneymov.repository.GenreRepository;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO genreDTO){
        Genre genre = genreMapper.genreDTO2Genre(genreDTO);
        Genre genreSaved = genreRepository.save(genre);
        GenreDTO result = genreMapper.Genre2genreDTO(genreSaved);
        return result;
    }
    
    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        List<GenreDTO> result = genreMapper.genreList2genreDTOList(genres);
        return result;
    }
    
    public void delete(Long id){
        this.genreRepository.deleteById(id);
    }
}
