package com.smilegate.blog.domain;

import com.smilegate.blog.domain.vo.Link;
import com.smilegate.blog.domain.vo.text.TitleBaseText;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BlockMedia extends Block {
    private final TitleBaseText title;
    private final Link link;
}
