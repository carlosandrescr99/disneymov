
package com.alkemy.disneymov.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "video")
@Getter
@Setter
@SQLDelete(sql = "UPDATE video SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String image;
    
    private Long rating;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
    
    private boolean deleted = Boolean.FALSE;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idgenre", insertable  = false, updatable = false)
    private Genre genre;
    
    @Column(name = "idgenre", nullable =false)
    private Long idgenre;
    
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
    return other.id == this.id;
    }
    
}
