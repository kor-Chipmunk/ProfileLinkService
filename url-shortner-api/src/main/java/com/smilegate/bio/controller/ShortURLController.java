package com.smilegate.bio.controller;

import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.CreateShortURLResponseDTO;
import com.smilegate.bio.service.ShortURLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shorts")
public class ShortURLController {
    private final ShortURLService shortURLService;

    @PostMapping
    public ResponseEntity<CreateShortURLResponseDTO> createShortURL(
            @RequestBody CreateShortURLRequestDTO request
    ) {
        final CreateShortURLResponseDTO response = shortURLService.getOrCreateShortURL(request);
        return ResponseEntity.ok(response);
    }
}
