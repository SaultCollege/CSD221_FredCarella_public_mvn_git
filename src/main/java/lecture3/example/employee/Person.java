/*
 * this is a superclass
 */

package lecture3.example.employee;

/**
 *
 * @author fcarella
 */
public class Person {
    private String firstname;
    private String lastname;

    public Person() {
        System.out.println("Calling Person() constructor");
        setFirstname("<default first name>");
        setLastname("<default last name>");
    }

    public Person(String firstname, String lastname) {
        System.out.println("Calling Person(String, String) constructor");
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return getFirstname()+" "+getLastname();
    }
}
