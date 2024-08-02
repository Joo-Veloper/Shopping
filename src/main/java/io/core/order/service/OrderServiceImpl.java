package io.core.order.service;

import io.core.discount.repository.DiscountPolicy;
import io.core.discount.repository.FixDiscountPolicy;
import io.core.member.entity.Member;
import io.core.member.repository.MemberRepository;
import io.core.member.repository.MemoryMemberRepository;
import io.core.order.entity.Order;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
