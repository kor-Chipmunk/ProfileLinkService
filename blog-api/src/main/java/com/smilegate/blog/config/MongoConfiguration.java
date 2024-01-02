package com.smilegate.blog.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@RequiredArgsConstructor
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private final Environment env;

    @Override
    protected String getDatabaseName() {
        return "blog";
    }

    @Override
    protected void configureClientSettings(Builder builder) {
        String uri = env.getProperty("spring.data.mongodb.uri");
        builder.applyConnectionString(new ConnectionString(uri));
    }

    @Override
    public MappingMongoConverter mappingMongoConverter(
            MongoDatabaseFactory databaseFactory
            , MongoCustomConversions customConversions
            , MongoMappingContext mappingContext
    ) {
        DbRefResolver resolver = new DefaultDbRefResolver(databaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(resolver, mappingContext);
        converter.setTypeMapper(new CustomMongoTypeMapper());
        return converter;
    }
}
