
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACR-Inc
 */
@Entity
@Table(name = "actor")
@XmlRootElement

public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactor")
    private Integer idactor;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Basic(optional = false)
    @Column(name = "weight")
    private int weight;
    @Basic(optional = false)
    @Column(name = "story")
    private String story;

    public Actor() {
    }

    public Actor(Integer idactor) {
        this.idactor = idactor;
    }

    public Actor(Integer idactor, String name, Date birth, int weight, String story) {
        this.idactor = idactor;
        this.name = name;
        this.birth = birth;
        this.weight = weight;
        this.story = story;
    }

    public Integer getIdactor() {
        return idactor;
    }

    public void setIdactor(Integer idactor) {
        this.idactor = idactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactor != null ? idactor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.idactor == null && other.idactor != null) || (this.idactor != null && !this.idactor.equals(other.idactor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Actor[ idactor=" + idactor + " ]";
    }
    
}
