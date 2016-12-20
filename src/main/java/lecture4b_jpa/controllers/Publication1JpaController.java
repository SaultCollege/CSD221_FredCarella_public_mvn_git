/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4b_jpa.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import lecture4b_jpa.controllers.exceptions.NonexistentEntityException;
import lecture4b_jpa.entities.Publication1;

/**
 *
 * @author fcarella
 */
public class Publication1JpaController implements Serializable {

    public Publication1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Publication1 publication1) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(publication1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Publication1 publication1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            publication1 = em.merge(publication1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = publication1.getId();
                if (findPublication1(id) == null) {
                    throw new NonexistentEntityException("The publication1 with id " + id + " no longer exists.");
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
            Publication1 publication1;
            try {
                publication1 = em.getReference(Publication1.class, id);
                publication1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The publication1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(publication1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Publication1> findPublication1Entities() {
        return findPublication1Entities(true, -1, -1);
    }

    public List<Publication1> findPublication1Entities(int maxResults, int firstResult) {
        return findPublication1Entities(false, maxResults, firstResult);
    }

    private List<Publication1> findPublication1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Publication1 as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Publication1 findPublication1(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Publication1.class, id);
        } finally {
            em.close();
        }
    }

    public int getPublication1Count() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Publication1 as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
