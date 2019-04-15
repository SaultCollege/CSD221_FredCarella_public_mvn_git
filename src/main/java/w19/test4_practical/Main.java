/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w19.test4_practical;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import w19.test4_practical.entities.Square;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("fred_carella_test4_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Square square=new Square();
            square.setTheLength(10.5);
            square.setWidth(20);
            square.printArea();
            em.persist(square);
//            List<Square> l=new ArrayList<Square>();
            ////////////////////
            em.getTransaction().commit();
            
            SquareJpaController squareJpaController=new SquareJpaController(emf);
            List<Square> squares = squareJpaController.findSquareEntities();
            for(Square b:squares){
                b.printArea();
            }
            
            
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
