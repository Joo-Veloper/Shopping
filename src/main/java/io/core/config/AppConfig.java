package io.core.config;

import io.core.discount.repository.DiscountPolicy;
import io.core.discount.repository.FixDiscountPolicy;
import io.core.member.repository.MemberRepository;
import io.core.member.repository.MemoryMemberRepository;
import io.core.member.service.MemberService;
import io.core.member.service.MemberServiceImpl;
import io.core.order.service.OrderService;
import io.core.order.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
