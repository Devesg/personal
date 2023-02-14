package com.personal.project.repository;

import java.util.List;
import java.util.Optional;

import com.personal.project.domain.Member;

public interface MemberRepository {
	
    Member save(Member member);
    
    List<Member> findAll();
    
    Optional<Member> findById(Long id);
    
    Optional<Member> findByName(String name);

}
