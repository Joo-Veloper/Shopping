package io.core.member.service;

import io.core.member.entity.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
