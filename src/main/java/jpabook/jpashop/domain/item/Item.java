package jpabook.jpashop.domain.item;


import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // 싱글 테이블 전략 사용
@DiscriminatorColumn(name = "dtype")    // @DiscriminatorValue("A") 등으로 구분함. (싱글테이블전략에서)
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
