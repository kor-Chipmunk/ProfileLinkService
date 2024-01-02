package com.smilegate.blog.controller.mapper;

import com.smilegate.blog.controller.dto.CreatePageResponseDTO;
import com.smilegate.blog.service.dto.PageResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePageResponseMapper {
    public static CreatePageResponseDTO create(PageResponse pageResponse) {
        return new CreatePageResponseDTO(
                pageResponse.pageId()
                , pageResponse.page().getName().getText()
        );
    }
}
