package jpabook.jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    try {
      Order order = new Order();
      order.addOrderItem(new OrderItem());
      entityManager.persist(order);
      OrderItem orderItem = new OrderItem();
      orderItem.setOrder(order);
      entityManager.persist(orderItem);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      entityManager.close();
    }
    entityManagerFactory.close();
  }
}
