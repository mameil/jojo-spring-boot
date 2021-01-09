package com.kyu.book.springboot.web;

import com.kyu.book.springboot.service.posts.PostsService;
import com.kyu.book.springboot.web.dto.PostsResponseDto;
import com.kyu.book.springboot.web.dto.PostsSaveRequestDto;
import com.kyu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
