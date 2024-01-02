package com.smilegate.blog.controller;

import com.smilegate.blog.controller.dto.CreatePageRequestDTO;
import com.smilegate.blog.controller.dto.CreatePageResponseDTO;
import com.smilegate.blog.controller.dto.ReadPageResponseDTO;
import com.smilegate.blog.controller.dto.UpdatePageRequestDTO;
import com.smilegate.blog.controller.mapper.CreatePageResponseMapper;
import com.smilegate.blog.controller.mapper.ReadPageResponseMapper;
import com.smilegate.blog.service.PageService;
import com.smilegate.blog.service.dto.CreatePageRequest;
import com.smilegate.blog.service.dto.PageResponse;
import com.smilegate.blog.service.dto.UpdatePageRequest;
import com.smilegate.blog.service.mapper.CreatePageRequestMapper;
import com.smilegate.blog.service.mapper.UpdatePageRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pages")
@RequiredArgsConstructor
public class PageController {
    private final PageService service;

    @PostMapping
    public ResponseEntity<CreatePageResponseDTO> createPage(@RequestBody CreatePageRequestDTO request) {
        CreatePageRequest createPageRequestDTO = CreatePageRequestMapper.create(request.name());
        PageResponse pageResponse = service.createPage(createPageRequestDTO);
        CreatePageResponseDTO response = CreatePageResponseMapper.create(pageResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{pageId}")
    public ResponseEntity<ReadPageResponseDTO> readPage(@PathVariable("pageId") String pageId) {
        PageResponse pageResponse = service.readPage(pageId);
        ReadPageResponseDTO response = ReadPageResponseMapper.create(pageResponse);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{pageId}")
    public ResponseEntity<ReadPageResponseDTO> updatePage(
            @PathVariable("pageId") String pageId
            , @RequestBody UpdatePageRequestDTO request
    ) {
        UpdatePageRequest updatePageDTO = UpdatePageRequestMapper.create(
                pageId
                , request.name()
                , request.profile()
                , request.blocks()
        );
        PageResponse pageResponse = service.updatePage(updatePageDTO);
        ReadPageResponseDTO response = ReadPageResponseMapper.create(pageResponse);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{pageId}")
    public ResponseEntity<ReadPageResponseDTO> deletePage(@PathVariable("pageId") String pageId) {
        PageResponse pageResponse = service.deletePage(pageId);
        ReadPageResponseDTO response = ReadPageResponseMapper.create(pageResponse);
        return ResponseEntity.ok(response);
    }
}
