
package com.alkemy.disneymov.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorFiltersDTO { 
    private String name;
    private String birth;
    private Set<Long> videos;
    private String order;
    
    public ActorFiltersDTO (String name, String birth , Set<Long> videos, String order){
    this.name = name;
    this.birth= birth;
    this.videos = videos;
    this.order = order;    
    }
    
    public boolean isASC(){return this.order.compareToIgnoreCase("ASC")==0;}
    
    public boolean isDESC(){return this.order.compareToIgnoreCase("DESC")==0;}
}
