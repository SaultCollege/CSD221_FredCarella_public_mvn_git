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
public class Main {
    public static void main(String[] args) {
        Person me=new Person();
        me.setFirstname("Joe");
        me.setLastname("Seeber");
        
        Person you=new Person("Luke", "Buck");
        
        Employee e1=new Employee();
        e1.setFirstname("Sylvan");
        e1.setLastname("Sauve");
        e1.setEmployer("Sault College");
        
        System.out.println("me =="+me);
        System.out.println("you =="+you);
        System.out.println("e1 =="+e1);
    }
}
