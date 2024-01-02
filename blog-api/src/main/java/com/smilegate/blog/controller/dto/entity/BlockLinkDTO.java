package com.smilegate.blog.controller.dto.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlockLinkDTO extends BlockDTO {
    private final String title;
    private final String link;
    private final String image;
}
