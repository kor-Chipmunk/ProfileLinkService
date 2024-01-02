package com.smilegate.blog;

import static org.assertj.core.api.Assertions.assertThat;

import com.mongodb.client.model.Filters;
import com.smilegate.blog.entity.mongo.BlockLinkEntity;
import com.smilegate.blog.entity.mongo.BlockProfileEntity;
import com.smilegate.blog.entity.mongo.BlockTextEntity;
import com.smilegate.blog.entity.mongo.PageEntity;
import com.smilegate.blog.repository.PageRepository;
import com.smilegate.blog.domain.vo.text.TextAlignment;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import util.MongoContainers;

@Testcontainers
@DataMongoTest
public class MongoDBTest {

    @Container
    private static MongoDBContainer mongoDBContainer = MongoContainers.getDefaultContainer();

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired MongoOperations operations;
    @Autowired PageRepository repository;

    @BeforeEach
    void setUp() {
        operations.remove(PageEntity.class).all();
    }

    @Test
    void insertTest() {
        PageEntity page = new PageEntity("name");

        BlockProfileEntity profile = new BlockProfileEntity(
                "main"
                , "sub"
                , "https://www.naver.com"
        );

        page.update(
                new BlockProfileEntity(
                        "main"
                        , "sub"
                        , "https://www.naver.com"
                )
            )
            .update(
                    List.of(
                        new BlockTextEntity(
                                "title"
                                , "sub"
                                , TextAlignment.CENTER
                        ),
                        new BlockLinkEntity(
                            "title",
                                "link",
                                "https://www.naver.com"
                        )
                    )
            );
        PageEntity savedPage = repository.save(page);

        System.out.println(savedPage.getId());

        Document stored = operations.execute(PageEntity.class, collection ->
            collection.find(Filters.eq("_id",savedPage.getId())).first()
        );

        assertThat(stored).containsAllEntriesOf(new Document("_id", savedPage.getId()));
    }
}
