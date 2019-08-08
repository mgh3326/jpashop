package jpabook.jpashop;

import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
      Book book = new Book();
      book.setName("JPA");
      book.setAuthor("김영한");
      em.persist(book);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }
}
