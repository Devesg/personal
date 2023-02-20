package com.personal.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.personal.project.domain.Post;
import com.personal.project.domain.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(Long id) {
    return postRepository.findById(id);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Post> findPostsByMemberId(Long memberId) {
        return postRepository.findAllByMemberIdOrderByCreatedAtDesc(memberId);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    // ...
}