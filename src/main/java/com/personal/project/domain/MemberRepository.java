package com.personal.project.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 기본적인 CRUD 기능은 JpaRepository에서 제공됨
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); // 추가된 메소드
    List<Member> findAll();
}