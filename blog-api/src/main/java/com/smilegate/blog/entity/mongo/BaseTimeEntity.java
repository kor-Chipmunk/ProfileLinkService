package com.smilegate.blog.entity.mongo;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class BaseTimeEntity {
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
