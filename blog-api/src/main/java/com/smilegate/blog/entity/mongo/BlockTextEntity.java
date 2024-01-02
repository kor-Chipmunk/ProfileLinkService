package com.smilegate.blog.entity.mongo;

import com.smilegate.blog.domain.vo.text.TextAlignment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("text")
@Getter
@NoArgsConstructor
public final class BlockTextEntity extends BlockEntity {
    private String title;
    private String content;
    private TextAlignment textAlignment;

    public BlockTextEntity(
            String title
            , String content
            , TextAlignment textAlignment
    ) {
        this.title = title;
        this.content = content;
        this.textAlignment = textAlignment;
    }
}
