package com.smilegate.blog.service;

import com.smilegate.blog.controller.dto.CreatePageResponseDTO;
import com.smilegate.blog.entity.mongo.PageEntity;
import com.smilegate.blog.entity.mongo.mapper.BlockEntityMapper;
import com.smilegate.blog.entity.mongo.mapper.BlockProfileEntityMapper;
import com.smilegate.blog.entity.mongo.mapper.PageEntityMapper;
import com.smilegate.blog.repository.PageRepository;
import com.smilegate.blog.service.dto.CreatePageRequest;
import com.smilegate.blog.service.dto.PageResponse;
import com.smilegate.blog.service.dto.UpdatePageRequest;
import com.smilegate.blog.service.mapper.PageResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PageService {
    private final PageRepository repository;

    @Transactional
    public PageResponse createPage(CreatePageRequest request) {
        PageEntity pageEntity = PageEntityMapper.create(request.name());
        repository.save(pageEntity);

        return PageResponseMapper.create(pageEntity);
    }

    public PageResponse readPage(String pageId) {
        PageEntity pageEntity = repository.findById(pageId).orElseThrow();

        return PageResponseMapper.create(pageEntity);
    }

    @Transactional
    public PageResponse updatePage(UpdatePageRequest request) {
        PageEntity pageEntity = repository.findById(request.pageId()).orElseThrow();

        pageEntity.update(BlockProfileEntityMapper.create(request.profile()));
        pageEntity.update(BlockEntityMapper.create(request.blocks()));
        repository.save(pageEntity);

        return PageResponseMapper.create(pageEntity);
    }

    @Transactional
    public PageResponse deletePage(String pageId) {
        PageEntity pageEntity = repository.findById(pageId).orElseThrow();
        repository.delete(pageEntity);

        return PageResponseMapper.create(pageEntity);
    }
}
