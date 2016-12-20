/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lecture3.example.employee;

/**
 *
 * @author fcarella
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("Person p=new Person();");
        Person p=new Person();// call super with no parameters
        System.out.println("System.out.println(p)==>"+p);
        System.out.println("------------------------");
        System.out.println("Person p2=new Person(\"Fred\", \"Carella\");");
        Person p2=new Person("Fred", "Carella");// call super with parameters
        System.out.println("System.out.println(p2)==>"+p2);
        System.out.println("------------------------");
        System.out.println("Employee e1=new Employee();");
        Employee e1=new Employee();
        System.out.println("System.out.println(e1)==>"+e1);
        System.out.println("------------------------");
        System.out.println("Employee e2=new Employee(\"Sault College\");");
        Employee e2=new Employee("Sault College");// call with employer only
        System.out.println("System.out.println(e2)==>"+e2);
        System.out.println("------------------------");
        System.out.println("Employee e3=new Employee(\"Fred\",\"Carella\", \"Sault College\");");
        Employee e3=new Employee("Fred","Carella", "Sault College");// call with employer
        System.out.println("System.out.println(e3)==>"+e3);
        System.out.println("------------------------");
    }



}
