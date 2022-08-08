
package com.alkemy.disneymov.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "actor")

public class Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer idactor;
    
    private String name;

    private String image;

    @Column(name = "birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate birth;
    
    private long weight;

    private String story;
    
    @ManyToMany (mappedBy = "actors", cascade = CascadeType.ALL)
    private List<Video> video = new ArrayList<>();
    
    public void addVideo(Video video) {this.video.add(video);}
    
    public void removeVideo(Video video) {this.video.remove(video);}
    
}
