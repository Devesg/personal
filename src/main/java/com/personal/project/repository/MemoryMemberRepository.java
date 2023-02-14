package com.personal.project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.personal.project.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    // 메모리 저장소
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 람다 스트림
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    public void clearStore()
    {
        store.clear();
    }
}
