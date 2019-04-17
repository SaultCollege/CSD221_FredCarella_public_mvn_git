/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w19.test4_review;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import w19.test4_review.entities.Regular_Emp;

/**
 *
 * @author fcarella
 */
public class Main {
public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("w19.test4_review_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Regular_Emp connor=new Regular_Emp();
            connor.setName("Connor Doda");
            connor.setSalary(5000);
            connor.setBonus(1000);
            em.persist(connor);
            ////////////////////
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            Logger.getLogger(w19.test4_practical.Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (emf != null) {
                emf.close();
            }
//            if(em!=null)
//                em.close();
        }
    }
}
