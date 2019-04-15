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
import w19.test4_practical.entities.Square;
import w19.test4_practical.exceptions.NonexistentEntityException;

/**
 *
 * @author FCAdmin
 */
public class SquareJpaController implements Serializable {

    public SquareJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Square square) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(square);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Square square) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            square = em.merge(square);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = square.getId();
                if (findSquare(id) == null) {
                    throw new NonexistentEntityException("The square with id " + id + " no longer exists.");
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
            Square square;
            try {
                square = em.getReference(Square.class, id);
                square.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The square with id " + id + " no longer exists.", enfe);
            }
            em.remove(square);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Square> findSquareEntities() {
        return findSquareEntities(true, -1, -1);
    }

    public List<Square> findSquareEntities(int maxResults, int firstResult) {
        return findSquareEntities(false, maxResults, firstResult);
    }

    private List<Square> findSquareEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Square as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Square findSquare(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Square.class, id);
        } finally {
            em.close();
        }
    }

    public int getSquareCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Square as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
