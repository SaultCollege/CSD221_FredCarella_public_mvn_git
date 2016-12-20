/*
 * Subclass
 */

package lecture3.example.employee;

public class Employee extends Person {
    private String employer;
    public Employee() {
        setEmployer("<default employer>");
        System.out.println("Calling Employee() constructor");
    }

    public Employee(String employer) {
        this.employer = employer;
        System.out.println("Calling Employee(String) constructor");
    }

    public Employee(String firstname, String lastname, String employer) {
        super(firstname, lastname);
        setEmployer(employer);
        System.out.println("Calling Employee(String, String, String) constructor");
    }
    public String getEmployer() {
        return employer;
    }
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return super.toString()+" works for "+getEmployer();
    }

}
