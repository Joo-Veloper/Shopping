package io.core.global.member.service;

import io.core.global.member.entity.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
