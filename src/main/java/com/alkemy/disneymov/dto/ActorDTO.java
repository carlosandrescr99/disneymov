
package com.alkemy.disneymov.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDTO {
    
    private Long id;    
    private String name;
    private String image;
    private LocalDate birth;    
    private long weight;
    private String story;   
    private Boolean deleted;
}
