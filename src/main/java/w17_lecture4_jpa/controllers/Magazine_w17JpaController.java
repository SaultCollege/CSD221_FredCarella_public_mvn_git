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
import w17_lecture4_jpa.entities.Magazine_w17;

/**
 *
 * @author fcarella
 */
public class Magazine_w17JpaController implements Serializable {

    public Magazine_w17JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Magazine_w17 magazine_w17) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(magazine_w17);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Magazine_w17 magazine_w17) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            magazine_w17 = em.merge(magazine_w17);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = magazine_w17.getId();
                if (findMagazine_w17(id) == null) {
                    throw new NonexistentEntityException("The magazine_w17 with id " + id + " no longer exists.");
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
            Magazine_w17 magazine_w17;
            try {
                magazine_w17 = em.getReference(Magazine_w17.class, id);
                magazine_w17.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The magazine_w17 with id " + id + " no longer exists.", enfe);
            }
            em.remove(magazine_w17);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Magazine_w17> findMagazine_w17Entities() {
        return findMagazine_w17Entities(true, -1, -1);
    }

    public List<Magazine_w17> findMagazine_w17Entities(int maxResults, int firstResult) {
        return findMagazine_w17Entities(false, maxResults, firstResult);
    }

    private List<Magazine_w17> findMagazine_w17Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Magazine_w17 as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Magazine_w17 findMagazine_w17(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Magazine_w17.class, id);
        } finally {
            em.close();
        }
    }

    public int getMagazine_w17Count() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Magazine_w17 as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
