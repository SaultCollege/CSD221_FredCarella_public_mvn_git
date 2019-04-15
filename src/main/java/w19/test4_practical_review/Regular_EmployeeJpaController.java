/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w19.test4_practical_review;

import chapter2.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import w19.test4_practical_review.entities.Regular_Employee;

/**
 *
 * @author FCAdmin
 */
public class Regular_EmployeeJpaController implements Serializable {

    public Regular_EmployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Regular_Employee regular_Employee) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(regular_Employee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Regular_Employee regular_Employee) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            regular_Employee = em.merge(regular_Employee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = regular_Employee.getId();
                if (findRegular_Employee(id) == null) {
                    throw new NonexistentEntityException("The regular_Employee with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Regular_Employee regular_Employee;
            try {
                regular_Employee = em.getReference(Regular_Employee.class, id);
                regular_Employee.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The regular_Employee with id " + id + " no longer exists.", enfe);
            }
            em.remove(regular_Employee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Regular_Employee> findRegular_EmployeeEntities() {
        return findRegular_EmployeeEntities(true, -1, -1);
    }

    public List<Regular_Employee> findRegular_EmployeeEntities(int maxResults, int firstResult) {
        return findRegular_EmployeeEntities(false, maxResults, firstResult);
    }

    private List<Regular_Employee> findRegular_EmployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Regular_Employee as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Regular_Employee findRegular_Employee(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Regular_Employee.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegular_EmployeeCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Regular_Employee as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
