//
// This file was generated by the JPA Modeler
//
package w16_lecture4_jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity

public class Magazine_w16 extends Publication_w16 implements Serializable {

    @Basic
    private Integer quantity;

    @Basic
    private String currentIssue;

    public Magazine_w16() {

    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrentIssue() {
        return this.currentIssue;
    }

    public void setCurrentIssue(String currentIssue) {
        this.currentIssue = currentIssue;
    }

}