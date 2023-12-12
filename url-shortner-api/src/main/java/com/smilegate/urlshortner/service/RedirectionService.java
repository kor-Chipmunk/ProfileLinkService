package com.smilegate.urlshortner.service;

import com.smilegate.urlshortner.dto.ShortURLDTO;
import com.smilegate.urlshortner.entity.ShortURL;
import com.smilegate.urlshortner.repository.ShortURLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedirectionService {
    private final ShortURLRepository shortURLRepository;

    public ShortURLDTO getShortURLByShortUrl(final String shortUrl) {
        final ShortURL shortURL = shortURLRepository.findByShortUrl(shortUrl)
                .orElseThrow();

        return ShortURLDTO.from(shortURL);
    }
}
