package com.smilegate.blog.repository;

import com.smilegate.blog.entity.mongo.PageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PageRepository extends MongoRepository<PageEntity, String> {
}
