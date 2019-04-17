package w19.test4_review.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author fcarella
 */

@Entity
public class Contract_Emp extends Emp {

    @Basic
    private double pay_per_hr;

    @Basic
    private int contract_period;

    public double getPay_per_hr() {
        return pay_per_hr;
    }

    public void setPay_per_hr(double pay_per_hr) {
        this.pay_per_hr = pay_per_hr;
    }

    public int getContract_period() {
        return contract_period;
    }

    public void setContract_period(int contract_period) {
        this.contract_period = contract_period;
    }

}