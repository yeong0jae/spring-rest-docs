package study.springrestdocs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequestDto {
    private String name;
    private String content;
}
