package io.core.global.discount.repository;

import io.core.global.member.entity.Grade;
import io.core.global.member.entity.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

/**
 * 1. @Qualifier끼리 매칭
 * 2. 빈 이름 매칭
 * 3. NoSuchBeanDefinitionException 예외 발생
 */
/*@Qualifier("fixDiscountPolicy")*/
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
