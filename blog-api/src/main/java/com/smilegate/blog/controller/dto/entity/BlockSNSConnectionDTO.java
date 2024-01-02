package com.smilegate.blog.controller.dto.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlockSNSConnectionDTO extends BlockDTO {
    private final String instagram;
    private final String telephone;
}
