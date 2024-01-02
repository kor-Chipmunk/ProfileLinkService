package com.smilegate.blog.entity.mongo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pages")
@Getter
@NoArgsConstructor
public final class PageEntity extends BaseTimeEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field
    private String name;

    private BlockProfileEntity blockProfile;

    private List<BlockEntity> blocks = new ArrayList<>();

    public PageEntity(final String name) {
        this.name = name;
    }

    public PageEntity update(final String name) {
        this.name = name;
        return this;
    }

    public PageEntity update(final BlockProfileEntity blockProfile) {
        this.blockProfile = blockProfile;
        return this;
    }

    public PageEntity update(final List<BlockEntity> blocks) {
        this.blocks = blocks;
        return this;
    }
}
