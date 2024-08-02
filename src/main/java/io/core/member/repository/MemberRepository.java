package io.core.member.repository;

import io.core.member.entity.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
