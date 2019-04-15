package w19.test4_practical.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author FCAdmin
 */

@Entity
public class Square extends Shape {

    @Basic
    private double width;

    @Basic
    private double theLength;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getTheLength() {
        return theLength;
    }

    public void setTheLength(double theLength) {
        this.theLength = theLength;
    }

    @Override
    public void printArea() {
        System.out.println("Area="+getWidth()*getTheLength());
    }

}