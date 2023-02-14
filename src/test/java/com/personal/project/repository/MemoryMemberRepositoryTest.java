package com.personal.project.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.personal.project.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    
    @AfterEach
    public void afterEach()
    {
        repository.clearStore();
    }

    @Test
    void testFindAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    void 저장() {
        Member member = new Member();
        member.setName("srping");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
    }
}
