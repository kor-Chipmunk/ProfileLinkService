package com.smilegate.blog.service.mapper;

import com.smilegate.blog.domain.vo.text.MainBaseText;
import com.smilegate.blog.service.dto.CreatePageRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePageRequestMapper {
    public static CreatePageRequest create(String name) {
        return new CreatePageRequest(
                new MainBaseText(name)
        );
    }
}
