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
import lecture4b_jpa.entities.Book1;

/**
 *
 * @author fcarella
 */
public class Book1JpaController implements Serializable {

    public Book1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Book1 book1) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(book1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Book1 book1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            book1 = em.merge(book1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = book1.getId();
                if (findBook1(id) == null) {
                    throw new NonexistentEntityException("The book1 with id " + id + " no longer exists.");
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
            Book1 book1;
            try {
                book1 = em.getReference(Book1.class, id);
                book1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The book1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(book1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Book1> findBook1Entities() {
        return findBook1Entities(true, -1, -1);
    }

    public List<Book1> findBook1Entities(int maxResults, int firstResult) {
        return findBook1Entities(false, maxResults, firstResult);
    }

    private List<Book1> findBook1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Book1 as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Book1 findBook1(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Book1.class, id);
        } finally {
            em.close();
        }
    }

    public int getBook1Count() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Book1 as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
