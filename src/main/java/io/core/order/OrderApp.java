package io.core.order;

import io.core.member.entity.Grade;
import io.core.member.entity.Member;
import io.core.member.service.MemberService;
import io.core.member.service.MemberServiceImpl;
import io.core.order.entity.Order;
import io.core.order.service.OrderService;
import io.core.order.service.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        // System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
