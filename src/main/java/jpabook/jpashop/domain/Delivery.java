package jpabook.jpashop.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")    // delivery_id 아님
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)    // 반드시 STRING으로 !! 기본인 ORDINAL을 사용할 경우 밀려서 꼬일 위험이 있어서.
    private DeliveryStatus status;  // ENUM타입: READY, COMP(배송)



}
