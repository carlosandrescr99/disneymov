
package com.alkemy.disneymov.entity;

import com.alkemy.disneymov.entity.Genre;
import com.alkemy.disneymov.entity.Actor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "video")
@Getter
@Setter

public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idvideo;

    private String title;

    private String image;
    
    private Integer rating;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateCreated;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idgenre", insertable  = false, updatable = false)
    private Genre genre;
    
    @Column(name = "idgenre", nullable =false)
    private int idgenre;
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "casting",
            joinColumns = @JoinColumn(name = "idvideo"),
            inverseJoinColumns = @JoinColumn(name = "idactor")
            )
    private Set<Actor> actors = new HashSet<>();
    
    @Override
    public boolean equals (Object obj){
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    final Video other = (Video) obj;
    return other.idvideo == this.idvideo;
    }
    
}
