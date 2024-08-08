package io.core.global.order.service;

import io.core.global.discount.repository.DiscountPolicy;
import io.core.global.member.entity.Member;
import io.core.global.member.repository.MemberRepository;
import io.core.global.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    /**
     * 필드 주입
     * 코드가 간결해서 많은 개발자들을 유혹하지만 외부에서 변경이 불가능해서 테스트 하기 힘들다.
     * 필드 주입은 사용하지 않는게 좋음
     * 필드 주입을 사용하는 순간 테스트 같은데서 값을 넣을 수 있는 방법 자체가 없고
     * 애플리케이션이 굉장이 딱딱해지고
     * 스프링 컨테이너 없이는 테스트 조차 할 수 없다.
     */

    //@Autowired
    private final MemberRepository memberRepository;
    //@Autowired
    private final DiscountPolicy discountPolicy;

    /**
     * 수정자 주입
     * 선택, 변경 가능성이 있는 의존관계에 사용
     * java Bean 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방식
     */

    /*@Autowired(required = false)
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

    /**
     * 생성자 주입
     * 불변 (final) 사용 가능 - 생성자에 혹시 값이 설정되지 않는 오류를 컴파일 시점에 막아준다.
     * 주입 데이터 누락시 컴파일 오류 발생
     */
    // 참고 : 수정자 주입을 포함한 나머지 주입 방식은 모두 생성자 이후에 호출되므로 필드에 final 키워드 사용할 수 없다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 일반 메서드 주입
     * 한번에 여러 필드 주입 받을 수 있다.
     * 일반적 잘 사용하지 X
     */

   /* @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
