package com.smilegate.blog.config;

import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;

public class CustomMongoTypeMapper extends DefaultMongoTypeMapper {

    private static final String TYPE_KEY = "type";

    public CustomMongoTypeMapper() {
        super(TYPE_KEY);
    }
}
