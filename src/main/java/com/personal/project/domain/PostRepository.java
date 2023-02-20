package com.personal.project.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedAtDesc();
    
    List<Post> findAllByMemberIdOrderByCreatedAtDesc(Long memberId);

}