
package com.alkemy.disneymov.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ACR-Inc
 */
@Entity
@Table(name = "genre")
@Getter
@Setter

public class Genre {

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idgenre;
    @Basic(optional = false)
    @Column(name = "name")
    
    private String name;
    @Basic(optional = false)
    
    @Column(name = "image")
    private String image;
    
}
