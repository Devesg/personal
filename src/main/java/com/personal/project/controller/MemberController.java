package com.personal.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MemberController {
    
    @GetMapping(value="/greeting")
    public String greeting(Model model) {

        return "/greeting";
    }
    
    @GetMapping(value="/register")
    public String register(@RequestParam String param) {
        return "/register";
    }
    
    @GetMapping(value="/get")
    public String get(@RequestParam String param) {
        return "/get";
    }
    
    @GetMapping(value="/getList")
    public String getList(@RequestParam String param) {
        return "/getList";
    }
    
    @GetMapping(value="/modify")
    public String modify(@RequestParam String param) {
        return "/modify";
    }

    @GetMapping(value="/remove")
    public String remove(@RequestParam String param) {
        return "/remove";
    }
}
