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
import w19.test4_practical.entities.Shape;
import w19.test4_practical.exceptions.NonexistentEntityException;

/**
 *
 * @author FCAdmin
 */
public class ShapeJpaController implements Serializable {

    public ShapeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Shape shape) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(shape);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Shape shape) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            shape = em.merge(shape);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = shape.getId();
                if (findShape(id) == null) {
                    throw new NonexistentEntityException("The shape with id " + id + " no longer exists.");
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
            Shape shape;
            try {
                shape = em.getReference(Shape.class, id);
                shape.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shape with id " + id + " no longer exists.", enfe);
            }
            em.remove(shape);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Shape> findShapeEntities() {
        return findShapeEntities(true, -1, -1);
    }

    public List<Shape> findShapeEntities(int maxResults, int firstResult) {
        return findShapeEntities(false, maxResults, firstResult);
    }

    private List<Shape> findShapeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Shape as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Shape findShape(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Shape.class, id);
        } finally {
            em.close();
        }
    }

    public int getShapeCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Shape as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
