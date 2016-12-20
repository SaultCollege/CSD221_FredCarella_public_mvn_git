package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class DiscMag extends Magazine implements Serializable {

    @Basic
    private Boolean hasDisk;

    public DiscMag() {

    }
    
    public Boolean isHasDisk() {
        return this.hasDisk;
    }

    public void setHasDisk(Boolean hasDisk) {
        this.hasDisk = hasDisk;
    }
}
