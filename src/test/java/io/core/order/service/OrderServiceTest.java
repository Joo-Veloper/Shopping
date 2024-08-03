package io.core.order.service;

import io.core.config.AppConfig;
import io.core.member.entity.Grade;
import io.core.member.entity.Member;
import io.core.member.service.MemberService;
import io.core.member.service.MemberServiceImpl;
import io.core.order.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

   /* MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();*/

    @Test
    void crateOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}