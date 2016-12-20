/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_exercise;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa_exercise.entities.Book;
import jpa_exercise.entities.Magazine;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("jpa_exercise");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Book book=new Book();
            book.setTitle("How to get banned from Facebook:  by an expert");
            book.setAuthor("Loris Rugolo");
            book.setPrice(20.00);
            em.persist(book);

            ////////////////////
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            //////////////
            Magazine magazine=new Magazine();
            magazine.setTitle("Facebook Sux: by Loris Rugolo");
            magazine.setPrice(10.00);
            em.persist(magazine);
            //////////////
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
