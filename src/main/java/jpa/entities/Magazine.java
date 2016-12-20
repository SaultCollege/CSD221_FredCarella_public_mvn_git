package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Magazine extends Publication implements Serializable {

    @Basic
    private String currentIssue;
    @Basic
    private Integer orderQty;

    public Magazine() {

    }
   
    public String getCurrentIssue() {
        return this.currentIssue;
    }

    public void setCurrentIssue(String currentIssue) {
        this.currentIssue = currentIssue;
    }
   
    public Integer getOrderQty() {
        return this.orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
}
