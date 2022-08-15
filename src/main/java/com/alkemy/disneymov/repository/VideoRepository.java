package com.alkemy.disneymov.repository;

import com.alkemy.disneymov.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository <Video, Long> {
    
}
