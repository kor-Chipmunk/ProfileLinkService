package com.smilegate.blog.entity.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("media")
@Getter
@NoArgsConstructor
public final class BlockMediaEntity extends BlockEntity {
    private String title;
    private String link;

    public BlockMediaEntity(
            String title
            , String link
    ) {
        this.title = title;
        this.link = link;
    }
}
