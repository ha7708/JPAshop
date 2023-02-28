package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")    // "B": 싱글테이블 전략에서 사용하므로 각 아이템 구분하기 위함
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;


}
