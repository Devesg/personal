package com.personal.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.personal.project.domain.Member;
import com.personal.project.service.MemberService;
import com.personal.project.web.SignupForm;

@Controller
public class SignupController {

    private final MemberService memberService;

    public SignupController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid SignupForm signupForm, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        Member member = new Member();
        member.setName(signupForm.getName());
        member.setEmail(signupForm.getEmail());
        member.setPassword(signupForm.getPassword()); // 패스워드 추가
        member.setPhone(signupForm.getPhone());
        member.setAddress(signupForm.getAddress());
        member.setGender(signupForm.getGender());
        member.setAge(signupForm.getAge());


        memberService.join(member);

        return "redirect:/";
    }
}