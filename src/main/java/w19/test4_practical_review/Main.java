/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w19.test4_practical_review;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import w19.test4_practical_review.entities.ContractEmployee;
import w19.test4_practical_review.entities.Regular_Employee;

/**
 *
 * @author fcarella
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("w19_test4_practical_review_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            //////////////
            Regular_Employee re=new Regular_Employee();
            re.setName("Joe Regular Employee");
            re.setSalary(2000.15f);
            re.setBonus(1000);
            em.persist(re);
            
            ContractEmployee ce= new ContractEmployee();
            ce.setName("Joe Contract Employee");
            ce.setPay_per_hr(100);
            ce.setContract_period(100);
            em.persist(ce);
//            List<Square> l=new ArrayList<Square>();
            ////////////////////
            em.getTransaction().commit();
            
            Regular_EmployeeJpaController controller=new Regular_EmployeeJpaController(emf);
            List<Regular_Employee> res = controller.findRegular_EmployeeEntities();
            for(Regular_Employee b:res){
                System.out.println("Yearly salary="+b.calcSalary());
            }
            
            ContractEmployeeJpaController cec=new ContractEmployeeJpaController(emf);
            List<ContractEmployee> ceList = cec.findContractEmployeeEntities();
            for(ContractEmployee c:ceList){
                System.out.println("Name="+c.getName()+", Salary="+c.calcSalary());
                c.setName("George Washington");
                cec.edit(c);
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
