package w19.test4_practical_review.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author FCAdmin
 */

@Entity
public class Regular_Employee extends Employee {

    @Basic
    private float salary;

    @Basic
    private int bonus;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}