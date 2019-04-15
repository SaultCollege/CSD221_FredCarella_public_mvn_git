package w19.test4_practical_review.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author FCAdmin
 */

@Entity
public class ContractEmployee extends Employee implements Serializable {

    @Basic
    private float pay_per_hr;

    @Basic
    private String contract_period;

    public float getPay_per_hr() {
        return pay_per_hr;
    }

    public void setPay_per_hr(float pay_per_hr) {
        this.pay_per_hr = pay_per_hr;
    }

    public String getContract_period() {
        return contract_period;
    }

    public void setContract_period(String contract_period) {
        this.contract_period = contract_period;
    }

}