package jpabook.jpashop.domain;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;

@Entity
public class Delivery {
  @Id
  @GeneratedValue
  private Long id;
  private String city;
  private String street;
  private String zipcode;
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery")
  private Order order;
}