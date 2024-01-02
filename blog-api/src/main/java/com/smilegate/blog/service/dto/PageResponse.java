package com.smilegate.blog.service.dto;

import com.smilegate.blog.domain.Page;

public record PageResponse(
        String pageId
        , Page page
) {
}
