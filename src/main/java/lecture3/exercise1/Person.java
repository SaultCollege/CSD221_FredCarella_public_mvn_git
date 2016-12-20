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
public class Person extends Object{
    private String firstname;
    private String lastname;
    private String middlename;
    
    public String toString(){
        return firstname+" "+lastname;
    }
    
    public Person(){
//        firstname="<not set>";
//        lastname="<not set>";
        this("<not set>", "<not set>");
        System.out.println("Person() constructor");
    }
    public Person(String firstname, String lastname){
        setFirstname(firstname);
        setLastname(lastname);
        System.out.println("Person(String, String) constructor");
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLasname(){
        return lastname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    /**
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
}
