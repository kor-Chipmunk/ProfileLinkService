package com.smilegate.blog.entity.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("profile")
@Getter
@NoArgsConstructor
public final class BlockProfileEntity extends BlockEntity {
    private String main;
    private String sub;
    private String image;

    public BlockProfileEntity(
            String main
            , String sub
            , String image
    ) {
        this.main = main;
        this.sub = sub;
        this.image = image;
    }
}
