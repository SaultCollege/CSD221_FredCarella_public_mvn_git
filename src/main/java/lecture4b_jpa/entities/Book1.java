package lecture4b_jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Book1 extends Publication1 implements Serializable {

    @Basic
    private String author;

    public Book1() {

    }
   
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
