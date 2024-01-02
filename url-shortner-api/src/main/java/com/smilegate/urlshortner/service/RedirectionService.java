package com.smilegate.urlshortner.service;

import com.smilegate.urlshortner.dto.ShortURLDTO;
import com.smilegate.urlshortner.entity.ShortURL;
import com.smilegate.urlshortner.repository.ShortURLRepository;
import com.smilegate.urlshortner.util.Base62Util;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedirectionService {
    private final ShortURLRepository shortURLRepository;

    public ShortURLDTO getShortURLByShortUrl(final String shortUrl) {
        final Long originalId = Base62Util.decode(shortUrl);
        final ShortURL shortURL = shortURLRepository.findByTicket(originalId)
                .orElseThrow();
        return ShortURLDTO.from(shortURL);
    }
}
