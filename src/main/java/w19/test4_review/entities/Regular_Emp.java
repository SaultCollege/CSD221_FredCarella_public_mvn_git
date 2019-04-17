package w19.test4_review.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author fcarella
 */

@Entity
public class Regular_Emp extends Emp {

    @Basic
    private double salary;

    @Basic
    private int bonus;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}