/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17_lecture4_jpa.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import w17_lecture4_jpa.controllers.exceptions.NonexistentEntityException;
import w17_lecture4_jpa.entities.Publication_w17;

/**
 *
 * @author fcarella
 */
public class Publication_w17JpaController implements Serializable {

    public Publication_w17JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Publication_w17 publication_w17) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(publication_w17);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Publication_w17 publication_w17) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            publication_w17 = em.merge(publication_w17);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = publication_w17.getId();
                if (findPublication_w17(id) == null) {
                    throw new NonexistentEntityException("The publication_w17 with id " + id + " no longer exists.");
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
            Publication_w17 publication_w17;
            try {
                publication_w17 = em.getReference(Publication_w17.class, id);
                publication_w17.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The publication_w17 with id " + id + " no longer exists.", enfe);
            }
            em.remove(publication_w17);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Publication_w17> findPublication_w17Entities() {
        return findPublication_w17Entities(true, -1, -1);
    }

    public List<Publication_w17> findPublication_w17Entities(int maxResults, int firstResult) {
        return findPublication_w17Entities(false, maxResults, firstResult);
    }

    private List<Publication_w17> findPublication_w17Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Publication_w17 as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Publication_w17 findPublication_w17(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Publication_w17.class, id);
        } finally {
            em.close();
        }
    }

    public int getPublication_w17Count() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Publication_w17 as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
