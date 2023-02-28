package jpabook.jpashop.domain;

// ENUM은 ORDINAL은 절대 금지. (순서에 의해 밀려 뒤틀릴수있음)
// @Enumerated(EnumType.STRING) 사용하며. @Enumerated(EnumType.ORDINAL) XXXXXXXX.. 금지
public enum DeliveryStatus {
    READY, COMP
}
