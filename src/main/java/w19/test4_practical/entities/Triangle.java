package w19.test4_practical.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author FCAdmin
 */

@Entity
public class Triangle extends Shape {

    @Basic
    private double base;

    @Basic
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public void printArea() {
        System.out.println("Area="+.5*getBase()*getHeight());
    }

}