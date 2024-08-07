package io.core.global.member.repository;

import io.core.global.member.entity.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
