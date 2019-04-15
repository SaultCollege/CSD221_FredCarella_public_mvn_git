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
import w19.test4_practical_review.entities.ContractEmployee;

/**
 *
 * @author FCAdmin
 */
public class ContractEmployeeJpaController implements Serializable {

    public ContractEmployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ContractEmployee contractEmployee) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contractEmployee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ContractEmployee contractEmployee) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contractEmployee = em.merge(contractEmployee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = contractEmployee.getId();
                if (findContractEmployee(id) == null) {
                    throw new NonexistentEntityException("The contractEmployee with id " + id + " no longer exists.");
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
            ContractEmployee contractEmployee;
            try {
                contractEmployee = em.getReference(ContractEmployee.class, id);
                contractEmployee.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contractEmployee with id " + id + " no longer exists.", enfe);
            }
            em.remove(contractEmployee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ContractEmployee> findContractEmployeeEntities() {
        return findContractEmployeeEntities(true, -1, -1);
    }

    public List<ContractEmployee> findContractEmployeeEntities(int maxResults, int firstResult) {
        return findContractEmployeeEntities(false, maxResults, firstResult);
    }

    private List<ContractEmployee> findContractEmployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ContractEmployee as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ContractEmployee findContractEmployee(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ContractEmployee.class, id);
        } finally {
            em.close();
        }
    }

    public int getContractEmployeeCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from ContractEmployee as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
