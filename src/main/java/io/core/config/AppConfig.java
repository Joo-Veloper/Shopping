package io.core.config;

import io.core.discount.repository.DiscountPolicy;
import io.core.discount.repository.FixDiscountPolicy;
import io.core.discount.repository.RateDiscountPolicy;
import io.core.member.repository.MemberRepository;
import io.core.member.repository.MemoryMemberRepository;
import io.core.member.service.MemberService;
import io.core.member.service.MemberServiceImpl;
import io.core.order.service.OrderService;
import io.core.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
