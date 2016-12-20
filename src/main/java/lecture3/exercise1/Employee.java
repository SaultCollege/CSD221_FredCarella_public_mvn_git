/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.exercise1;

/**
 *
 * @author fcarella
 */
public class Employee extends Person {
    private String employer;

    public Employee() {
        employer="<not set>";
        System.out.println("Employee() constructor");
    }

    public Employee(String employer, String firstname, String lastname) {
        super(firstname, lastname);
//        setFirstname(firstname);
//        setLastname(lastname);
        this.employer = employer;
        System.out.println("Employee(String, String, String) constructor");

    }

    @Override
    public String toString() {
        String s="My name is "+getFirstname()+" "+getLasname()+" and I work for "+employer;
        
        return s;
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
