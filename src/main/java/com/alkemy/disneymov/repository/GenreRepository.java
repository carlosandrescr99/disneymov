
package com.alkemy.disneymov.repository;

import com.alkemy.disneymov.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository <Genre, Long> {
    
}
