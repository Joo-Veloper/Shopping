package io.core.order;

import io.core.scan.AppConfig;
import io.core.member.entity.Grade;
import io.core.member.entity.Member;
import io.core.member.service.MemberService;
import io.core.order.entity.Order;
import io.core.order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/
        /*MemberService memberService = new MemberServiceImpl(null);
        OrderService orderService = new OrderServiceImpl(null,null);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        // System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
