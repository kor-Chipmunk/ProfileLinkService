package com.smilegate.bio.service;

import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedirectionService {
    private final ShortURLRepository shortURLRepository;

    public ShortURLDTO getShortURLById(Long id) {
        final ShortURL shortURL = shortURLRepository.findById(id)
                .orElseThrow();

        return ShortURLDTO.from(shortURL);
    }
}
