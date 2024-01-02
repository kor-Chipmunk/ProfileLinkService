package com.smilegate.blog.domain;

import com.smilegate.blog.domain.vo.Image;
import com.smilegate.blog.domain.vo.text.MainBaseText;
import com.smilegate.blog.domain.vo.text.SubBaseText;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BlockProfile extends Block {
    private final MainBaseText main;
    private final SubBaseText sub;
    private final Image profileImage;
}
