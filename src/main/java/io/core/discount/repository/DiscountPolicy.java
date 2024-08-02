package io.core.discount.repository;

import io.core.member.entity.Member;

public interface DiscountPolicy {

    /**
     * @return 이 할인 대상 금액
     */
    int discount(Member member, int price);

}
