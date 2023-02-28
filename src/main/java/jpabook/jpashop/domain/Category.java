package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;


    private String name;

    @ManyToMany // 객체와는 달리 RDBMS는 중간 테이블이 필요함. (1:N , N:1) - CATEGORY_ITEM 테이블, 실무에서 사용 X(예제처럼 단순한 구조가 아니므로 실용성 없음)
    @JoinTable(name = "category_item",  // 중간 테이블 이름 category_item
        joinColumns = @JoinColumn(name = "category_id"),    // FK인 category_id (CATEGORY 테이블과 매핑)
            inverseJoinColumns = @JoinColumn(name = "item_id"))     // FK인 item_id (ITEM 테이블과 매핑)
    private List<Item> items = new ArrayList<>();


    // ------------------------------------------------------------- //
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")    // 자기 자신(Category)과 매핑
    private List<Category> child = new ArrayList<>();
    // ------------------------------------------------------------- //


}
