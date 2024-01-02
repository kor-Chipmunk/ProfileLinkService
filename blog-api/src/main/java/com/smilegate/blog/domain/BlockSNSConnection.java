package com.smilegate.blog.domain;


import com.smilegate.blog.domain.vo.text.InstagramText;
import com.smilegate.blog.domain.vo.text.TelephoneBaseText;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class BlockSNSConnection extends Block {
    private final InstagramText instagram;
    private final TelephoneBaseText telephone;
}
