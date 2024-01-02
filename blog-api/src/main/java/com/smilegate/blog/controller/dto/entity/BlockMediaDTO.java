package com.smilegate.blog.controller.dto.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlockMediaDTO extends BlockDTO {
    private final String title;
    private final String link;
}
