package io.core.member;

import io.core.config.AppConfig;
import io.core.member.entity.Grade;
import io.core.member.entity.Member;
import io.core.member.service.MemberService;
import io.core.member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
