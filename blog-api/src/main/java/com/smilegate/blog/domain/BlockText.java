package com.smilegate.blog.domain;

import com.smilegate.blog.domain.vo.text.ContentBaseText;
import com.smilegate.blog.domain.vo.text.TextAlignment;
import com.smilegate.blog.domain.vo.text.TitleBaseText;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class BlockText extends Block {
    private final TitleBaseText title;
    private final ContentBaseText content;
    private final TextAlignment textAlignment;
}
