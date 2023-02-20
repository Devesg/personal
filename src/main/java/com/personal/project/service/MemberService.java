package com.personal.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.project.domain.Member;
import com.personal.project.domain.MemberRepository;
import com.personal.project.exception.DuplicateMemberException;
import com.personal.project.exception.MemberNotFoundException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException());
    }

    public Member join(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    public Member update(Long id, Member updatedMember) {
        Member member = findById(id);
        member.setName(updatedMember.getName());
        member.setEmail(updatedMember.getEmail());
        return memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new DuplicateMemberException(member.getName());
                });
    }

    public Member getMemberFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
    
        Object sessionObj = session.getAttribute("loginMember");
        if (sessionObj == null) {
            return null;
        }
    
        return (Member) sessionObj;
    }
}