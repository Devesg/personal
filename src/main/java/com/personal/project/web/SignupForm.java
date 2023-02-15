package com.personal.project.web;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignupForm {

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotEmpty(message = "전화번호는 필수 입력 값입니다.")
    private String phone;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

    @NotEmpty(message = "성별은 필수 입력 값입니다.")
    private String gender;

    private int age;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
}