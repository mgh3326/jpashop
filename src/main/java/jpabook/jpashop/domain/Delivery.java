package jpabook.jpashop.domain;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {
  @Id
  @GeneratedValue
  private Long id;
  private String city;
  private String street;
  private String zipcode;
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  private Order order;
}
