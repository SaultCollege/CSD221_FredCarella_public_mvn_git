/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_practical_test_review;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lab5_practical_test_review.controllers.CarJpaController;
import lab5_practical_test_review.controllers.TruckJpaController;
import lab5_practical_test_review.controllers.VehicleJpaController;
import lab5_practical_test_review.entities.Car;
import lab5_practical_test_review.entities.Truck;
import lab5_practical_test_review.entities.Vehicle;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("practical_PU");
            em = emf.createEntityManager();
            //////////////
            em.getTransaction().begin();
            Car mustang=new Car();
            mustang.setModel("Mustang");
            mustang.setVin("1234");
            
            Truck sierra=new Truck();
            sierra.setAxles("2");
            sierra.setVin("6789");
            
            em.persist(mustang);
            em.persist(sierra);
            em.getTransaction().commit();
            ////////////////////
            //////////////
            CarJpaController cc=new CarJpaController(emf);
            TruckJpaController tc=new TruckJpaController(emf);
            Car mustang2=new Car();
            mustang2.setModel("Mustang2");
            mustang2.setVin("123400");
            
            Truck sierra2=new Truck();
            sierra2.setAxles("4");
            sierra2.setVin("678900");
            
            cc.create(mustang2);
            tc.create(sierra2);
            
            VehicleJpaController vc=new VehicleJpaController(emf);
            List<Vehicle> listAll = vc.findVehicleEntities();
            for(Vehicle v:listAll){
                System.out.println(v.getVin());
            }
            List<Truck> listAllTrucks = tc.findTruckEntities();
            for(Truck v:listAllTrucks){
                System.out.println(v.getAxles());
            }
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
