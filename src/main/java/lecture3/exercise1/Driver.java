/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.exercise1;

import java.util.ArrayList;

/**
 *
 * @author fcarella
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("-----PERSON----");
        Person p=new Person();
        System.out.println(p);
        
        System.out.println("-----EMPLOYEE 1----");
        Employee e=new Employee();
        System.out.println(e);
        
        System.out.println("-----EMPLOYEE 2----");
        Employee e2=new Employee("Sault College", "Fred", "Carella");
        System.out.println(e2);
        
        
        ArrayList<Person> employees=new ArrayList<>();
        
        Person joe=new Person("Joe", "Student");
        Person mike=new Person("Mike", "Student");
        
        employees.add(joe);
        employees.add(mike);
        
        // METHOD 1: process the arraylist
        for(int i=0;i<employees.size();i++){
            System.out.println((i+1)+":"+employees.get(i));
            
        }
        // METHOD 2: process the arraylist
        for(Person p1:employees){
            System.out.println(p1);
            
        }
        
        employees.remove(0);
        // METHOD 1: process the arraylist
        for(int i=0;i<employees.size();i++){
            System.out.println((i+1)+":"+employees.get(i));
            
        }
        
        
    }
}
