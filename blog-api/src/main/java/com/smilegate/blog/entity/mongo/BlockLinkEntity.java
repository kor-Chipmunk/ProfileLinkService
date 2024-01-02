package com.smilegate.blog.entity.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("link")
@Getter
@NoArgsConstructor
public final class BlockLinkEntity extends BlockEntity {
    private String title;
    private String link;
    private String image;

    public BlockLinkEntity(
            String title
            , String link
            , String image
    ) {
        this.title = title;
        this.link = link;
        this.image = image;
    }
}
