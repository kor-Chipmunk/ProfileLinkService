package com.smilegate.blog.controller.dto.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlockProfileDTO extends BlockDTO {
    private final String main;
    private final String sub;
    private final String profileImage;
}
