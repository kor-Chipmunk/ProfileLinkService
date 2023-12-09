package com.smilegate.bio.service;

import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShortURLService {
    private final ShortURLRepository shortURLRepository;

    @Transactional
    public ShortURLDTO createShortURL(CreateShortURLRequestDTO request) {
        final ShortURL shortURL = new ShortURL(request.originUrl());

        shortURLRepository.save(shortURL);

        return ShortURLDTO.from(shortURL);
    }
}
