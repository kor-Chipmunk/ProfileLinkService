package com.smilegate.blog.service.dto;

import com.smilegate.blog.domain.Block;
import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.domain.vo.text.MainBaseText;
import java.util.List;

public record UpdatePageRequest(
        String pageId
        , MainBaseText name
        , BlockProfile profile
        , List<Block> blocks
) {
}
