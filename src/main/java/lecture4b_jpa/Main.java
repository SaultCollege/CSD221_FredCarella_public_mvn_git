/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4b_jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lecture4b_jpa.controllers.Book1JpaController;
import lecture4b_jpa.entities.Book1;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("Try2_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Book1 book1=new Book1();
            book1.setAuthor("Me");
            book1.setCopies(5);
            book1.setTitle("Java is fun!");
            book1.setPrice(9.50);
            
            em.persist(book1);
            
            Book1JpaController book1JpaController=new Book1JpaController(emf);
            
            Book1 book2=new Book1();
            book2.setAuthor("Me");
            book2.setCopies(5);
            book2.setTitle("Java is Super Fun! 2e");
            book2.setPrice(19.50);
            book1JpaController.create(book2);
            
            List<Book1> books = book1JpaController.findBook1Entities();
            for(Book1 b:books){
                System.out.println(b.getTitle());
            }
            for(Book1 b:books){
                book1.setTitle(book1.getTitle()+"_"+System.currentTimeMillis());
                book1JpaController.edit(book1);
            }
            books = book1JpaController.findBook1Entities();
            for(Book1 b:books){
                System.out.println(b.getTitle());
            }
            for(Book1 b:books){
//                book1JpaController.destroy(b.getId());
            }
            
            ////////////////////
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (emf != null) {
                emf.close();
            }
//            if(em!=null)
//                em.close();
        }
    }

}
