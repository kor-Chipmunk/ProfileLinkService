package com.smilegate.blog.entity.mongo;

import org.bson.types.ObjectId;

public abstract class BlockEntity {
    protected String key;

    protected BlockEntity() {
        this.key = ObjectId.get().toHexString();
    }
}
