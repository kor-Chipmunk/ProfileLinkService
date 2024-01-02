package com.smilegate.blog.entity.mongo.mapper;

import com.smilegate.blog.domain.vo.text.MainBaseText;
import com.smilegate.blog.entity.mongo.PageEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageEntityMapper {
    public static PageEntity create(MainBaseText name) {
        return new PageEntity(name.getText());
    }
}
