
package com.alkemy.disneymov.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDTO {
    
    private Long id;
    private String title;
    private String image;
    private Long rating;
    private LocalDate dateCreated;
    private Long idgenre;
    private Boolean deleted;
}
