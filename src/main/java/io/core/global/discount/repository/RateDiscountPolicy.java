package io.core.global.discount.repository;

import io.core.global.annotation.MainDiscountPolicy;
import io.core.global.member.entity.Grade;
import io.core.global.member.entity.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

/**
 * 1. @Qualifier끼리 매칭
 * 2. 빈 이름 매칭
 * 3. NoSuchBeanDefinitionException 예외 발생
 */
/*@Qualifier("mainDiscountPolicy")*/

/**
 * @Primary는 우선순위를 정하는 방법이다. @Autowired 시에 여러 빈이 매칭되면 @Primary가 우선권을 가진다.
 */
/*@Primary*/

@MainDiscountPolicy

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
