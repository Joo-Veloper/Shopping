package io.core.global.order.service;

import io.core.global.discount.repository.FixDiscountPolicy;
import io.core.global.member.entity.Grade;
import io.core.global.member.entity.Member;
import io.core.global.member.repository.MemberRepository;
import io.core.global.member.repository.MemoryMemberRepository;
import io.core.global.order.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}