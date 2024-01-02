package com.smilegate.blog.controller.dto.entity;

import com.smilegate.blog.domain.vo.text.TextAlignment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlockTextDTO extends BlockDTO {
    private final String title;
    private final String content;
    private final TextAlignment textAlignment;
}
