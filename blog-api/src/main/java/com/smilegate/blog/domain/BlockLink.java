package com.smilegate.blog.domain;

import com.smilegate.blog.domain.vo.Image;
import com.smilegate.blog.domain.vo.Link;
import com.smilegate.blog.domain.vo.text.TitleBaseText;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BlockLink extends Block {
    private final TitleBaseText title;
    private final Link link;
    private final Image image;
}
