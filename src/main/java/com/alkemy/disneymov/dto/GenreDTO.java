
package com.alkemy.disneymov.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    
    private Long id;
    private String name;  
    private String image;
    private Boolean deleted;
}
