/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.w16.ex1;

/**
 *
 * @author fcarella
 */
public class Employee extends Person {
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
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
