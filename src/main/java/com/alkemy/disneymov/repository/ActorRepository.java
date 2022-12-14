
package com.alkemy.disneymov.repository;

import com.alkemy.disneymov.entity.Actor;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Long>, JpaSpecificationExecutor<Actor> {
    List<Actor> findAll(Specification<Actor> spec);
}
