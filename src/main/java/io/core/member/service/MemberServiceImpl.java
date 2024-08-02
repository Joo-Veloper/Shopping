package io.core.member.service;

import io.core.member.entity.Member;
import io.core.member.repository.MemberRepository;
import io.core.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
