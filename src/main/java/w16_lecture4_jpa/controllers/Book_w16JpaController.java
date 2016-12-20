/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w16_lecture4_jpa.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import w16_lecture4_jpa.controllers.exceptions.NonexistentEntityException;
import w16_lecture4_jpa.entities.Book_w16;

/**
 *
 * @author fcarella
 */
public class Book_w16JpaController implements Serializable {

    public Book_w16JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Book_w16 book_w16) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(book_w16);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Book_w16 book_w16) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            book_w16 = em.merge(book_w16);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = book_w16.getId();
                if (findBook_w16(id) == null) {
                    throw new NonexistentEntityException("The book_w16 with id " + id + " no longer exists.");
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
            Book_w16 book_w16;
            try {
                book_w16 = em.getReference(Book_w16.class, id);
                book_w16.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The book_w16 with id " + id + " no longer exists.", enfe);
            }
            em.remove(book_w16);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Book_w16> findBook_w16Entities() {
        return findBook_w16Entities(true, -1, -1);
    }

    public List<Book_w16> findBook_w16Entities(int maxResults, int firstResult) {
        return findBook_w16Entities(false, maxResults, firstResult);
    }

    private List<Book_w16> findBook_w16Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Book_w16 as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Book_w16 findBook_w16(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Book_w16.class, id);
        } finally {
            em.close();
        }
    }

    public int getBook_w16Count() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Book_w16 as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
