/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.example.employee.w19;

/**
 *
 * @author fcarella
 */
public class Main {
    public static void main(String[] args) {
        Person p=new Person();
        Person p2=new Person("Mathew", "Stanghetta");
        System.out.println(p);
        System.out.println(p2);
        
        Employee e1=new Employee();
        Employee e2=new Employee("Mary", "Joe");
        System.out.println(e1);
        System.out.println(e2);
    }
}
