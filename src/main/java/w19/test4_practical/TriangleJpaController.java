/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w19.test4_practical;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import w19.test4_practical.entities.Triangle;
import w19.test4_practical.exceptions.NonexistentEntityException;

/**
 *
 * @author FCAdmin
 */
public class TriangleJpaController implements Serializable {

    public TriangleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Triangle triangle) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(triangle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Triangle triangle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            triangle = em.merge(triangle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = triangle.getId();
                if (findTriangle(id) == null) {
                    throw new NonexistentEntityException("The triangle with id " + id + " no longer exists.");
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
            Triangle triangle;
            try {
                triangle = em.getReference(Triangle.class, id);
                triangle.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The triangle with id " + id + " no longer exists.", enfe);
            }
            em.remove(triangle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Triangle> findTriangleEntities() {
        return findTriangleEntities(true, -1, -1);
    }

    public List<Triangle> findTriangleEntities(int maxResults, int firstResult) {
        return findTriangleEntities(false, maxResults, firstResult);
    }

    private List<Triangle> findTriangleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Triangle as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Triangle findTriangle(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triangle.class, id);
        } finally {
            em.close();
        }
    }

    public int getTriangleCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Triangle as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
