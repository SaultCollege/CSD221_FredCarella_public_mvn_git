/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4.w17;

/**
 *
 * @author fcarella
 */
public class Employee extends Person{
    private String employer;

    public Employee() {
    }

    public Employee(String employer) {
        this.employer = employer;
    }

    public Employee(String employer, String firstname, String lastname) {
        super(firstname, lastname);
        this.employer = employer;
    }

    @Override
    public String toString() {
        String fl=super.toString(); //To change body of generated methods, choose Tools | Templates.
        return fl+" employed by"+getEmployer();
    }

    
    
    /**
     * @return the employer
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @param employer the employer to set
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }
    
}
