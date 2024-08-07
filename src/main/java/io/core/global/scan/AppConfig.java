package io.core.global.scan;

import io.core.global.discount.repository.DiscountPolicy;
import io.core.global.discount.repository.RateDiscountPolicy;
import io.core.global.member.repository.MemberRepository;
import io.core.global.member.repository.MemoryMemberRepository;
import io.core.global.member.service.MemberService;
import io.core.global.member.service.MemberServiceImpl;
import io.core.global.order.service.OrderService;
import io.core.global.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
