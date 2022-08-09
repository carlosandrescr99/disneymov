
package com.alkemy.disneymov.controller;

import com.alkemy.disneymov.dto.GenreDTO;
import com.alkemy.disneymov.services.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("epgenres")

public class GenreController {
    
    @Autowired
    private GenreService genreService;
    
    @GetMapping
    public ResponseEntity <List<GenreDTO>> getAll() {
        List<GenreDTO> genres =genreService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }
    
    @PostMapping 
    public ResponseEntity <GenreDTO> save(@RequestBody GenreDTO genre){
        GenreDTO genreSaved = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
   
   } 
}
