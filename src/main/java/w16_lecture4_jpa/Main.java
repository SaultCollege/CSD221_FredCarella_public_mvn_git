/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w16_lecture4_jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import w16_lecture4_jpa.controllers.Book_w16JpaController;
import w16_lecture4_jpa.entities.Book_w16;
import w16_lecture4_jpa.entities.Magazine_w16;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("jpa_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Book_w16 book1=new Book_w16();
            book1.setAuthor("Me");
            book1.setCopies(5);
            book1.setTitle("Java is fun!");
            book1.setPrice(9.50);
            
            em.persist(book1);
            Magazine_w16 magazine1=new Magazine_w16();
            magazine1.setCopies(6);
            magazine1.setCurrentIssue("March 2, 2016");
            magazine1.setPrice(5.5);
            magazine1.setQuantity(10);
            magazine1.setTitle("This is a magazine!");
            em.persist(magazine1);
            
            
            Book_w16JpaController bookController=new Book_w16JpaController(emf);
            Book_w16 book2=new Book_w16();
            bookController.create(book2);
            
            book2.setAuthor("Me");
            bookController.edit(book2);
            em.getTransaction().commit();
            

            List<Book_w16> list = bookController.findBook_w16Entities();
            for(Book_w16 b:list){
                System.out.println(b.getAuthor());
            }
            
/*            Book_w16JpaController book1JpaController=new Book_w16JpaController(emf);
            
            Book_w16 book2=new Book_w16();
            book2.setAuthor("Me");
            book2.setCopies(5);
            book2.setTitle("Java is Super Fun! 2e");
            book2.setPrice(19.50);
            book1JpaController.create(book2);
            
            List<Book_w16> books = book1JpaController.findBook_w16Entities();
            for(Book_w16 b:books){
                System.out.println(b.getTitle());
            }
            for(Book_w16 b:books){
                book1.setTitle(book1.getTitle()+"_"+System.currentTimeMillis());
                book1JpaController.edit(book1);
            }
            books = book1JpaController.findBook_w16Entities();
            for(Book_w16 b:books){
                System.out.println(b.getTitle());
            }
            for(Book_w16 b:books){
//                book1JpaController.destroy(b.getId());
            }
*/            
            ////////////////////
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
