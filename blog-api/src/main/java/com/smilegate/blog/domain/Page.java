package com.smilegate.blog.domain;

import com.smilegate.blog.domain.vo.text.MainBaseText;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Page {
    private final MainBaseText name;
    private final BlockProfile profile;
    private final List<Block> blocks;
}
