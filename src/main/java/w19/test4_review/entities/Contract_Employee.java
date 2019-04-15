package w19.test4_review.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author fcarella
 */

@Entity
public class Contract_Employee extends Employee {

    @Basic
    private float pay_per_hour;

    @Basic
    private int contract_period;

    public float getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(float pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }

    public int getContract_period() {
        return contract_period;
    }

    public void setContract_period(int contract_period) {
        this.contract_period = contract_period;
    }

}