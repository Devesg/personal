package com.personal.project.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.personal.project.domain.Member;
import com.personal.project.domain.Post;
import com.personal.project.service.MemberService;
import com.personal.project.service.PostService;
import com.personal.project.web.PostForm;

@Controller
public class PostController {

    private final PostService postService;
    private final MemberService memberService;
    
    public PostController(PostService postService, MemberService memberService) {
        this.postService = postService;
        this.memberService = memberService;
    }

    @GetMapping("/posts")
    public String list(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/posts/new")
    public String createForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "post/postForm";
    }

    @PostMapping("/posts/new")
    public String create(@ModelAttribute("postForm") PostForm form, Model model, HttpServletRequest session) {
        Member member = memberService.getMemberFromSession(session);
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setMember(member);
        postService.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{postId}")
    public String detail(@PathVariable Long postId, Model model) {
        Optional<Post> post = postService.findById(postId);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @GetMapping("/posts/{postId}/edit")
    public String updateForm(@PathVariable Long postId, Model model) {
        Optional<Post> post = postService.findById(postId);
        model.addAttribute("postForm", post.get());
        return "post/postForm";
    }

    @PostMapping("/posts/{postId}/edit")
    public String update(@PathVariable Long postId, @ModelAttribute("postForm") PostForm form) {
        Optional<Post> post = postService.findById(postId);

        post.get().setTitle(form.getTitle());
        post.get().setContent(form.getContent());
        postService.save(post.get());

        return "redirect:/posts/{postId}";
    }

    @PostMapping("/posts/{postId}/delete")
    public String delete(@PathVariable Long postId) {
        Optional<Post> post = postService.findById(postId);

        postService.delete(post.get());
        return "redirect:/posts";
    }
}