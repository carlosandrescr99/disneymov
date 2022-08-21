
package com.alkemy.disneymov.repository.specifications;


import com.alkemy.disneymov.entity.Actor;
import com.alkemy.disneymov.dto.ActorFiltersDTO;
import com.alkemy.disneymov.entity.Video;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class ActorSpecification {
    public Specification<Actor> getByFilters(ActorFiltersDTO actorFiltersDTO){
        return(root, query, criteriaBuilder)->{
            List<Predicate> predicates = new ArrayList<>();
            
            if (StringUtils.hasLength(actorFiltersDTO.getName())){
                predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")),
                        "%" + actorFiltersDTO.getName() +"%"
                    )
                );
            }

            if (StringUtils.hasLength(actorFiltersDTO.getBirth())){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(actorFiltersDTO.getBirth(), formatter);
                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("birth"), date)
                );
            }
            
            if(!CollectionUtils.isEmpty(actorFiltersDTO.getVideos())){
                Join<Video, Actor> join = root.join("videos", JoinType.INNER);
                Expression<String> videosId = join.get("id");
                predicates.add(videosId.in(actorFiltersDTO.getVideos()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }  
}
