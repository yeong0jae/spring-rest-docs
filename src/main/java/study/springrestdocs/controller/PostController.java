package study.springrestdocs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.springrestdocs.domain.Post;
import study.springrestdocs.domain.dto.PostRequestDto;
import study.springrestdocs.domain.dto.PostResponseDto;

@RestController
public class PostController {

    @GetMapping("/post")
    public ResponseEntity getPost() {
        Post post = buildPost("RestDocs", "Rest Document에 관한 게시글입니다.");

        PostResponseDto postResponseDto = buildResponseDto(post);
        return ResponseEntity.ok(postResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = buildPost(postRequestDto.getName(), postRequestDto.getContent());
        PostResponseDto postResponseDto = buildResponseDto(post);
        return ResponseEntity.ok(postResponseDto);
    }

    private static Post buildPost(String name, String content) {
        return  Post.builder()
                .name(name)
                .content(content)
                .build();
    }

    private static PostResponseDto buildResponseDto(Post post) {
        PostResponseDto postResponseDto = PostResponseDto.builder()
                .name(post.getName())
                .content(post.getContent())
                .build();
        return postResponseDto;
    }
}
