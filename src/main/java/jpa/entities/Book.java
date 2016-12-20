package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Book extends Publication implements Serializable {

    @Basic
    private String author;

    public Book() {

    }
   
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
