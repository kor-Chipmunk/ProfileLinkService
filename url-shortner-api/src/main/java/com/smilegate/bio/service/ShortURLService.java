package com.smilegate.bio.service;

import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.CreateShortURLResponseDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
import java.net.URL;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShortURLService {
    private final ShortURLRepository shortURLRepository;

    @Transactional
    public CreateShortURLResponseDTO getOrCreateShortURL(final CreateShortURLRequestDTO request) {
        final String originURL = removedTrailSlash(request.originUrl());
        validateOriginURL(originURL);

        final Optional<ShortURL> retrievalShortURL = shortURLRepository.findByOriginUrl(originURL);
        if (retrievalShortURL.isPresent()) {
            return CreateShortURLResponseDTO.from(retrievalShortURL.get());
        }

        final ShortURL shortURLEntity = new ShortURL(request.originUrl());
        final ShortURL createdShortURL = shortURLRepository.save(shortURLEntity);

        return CreateShortURLResponseDTO.from(createdShortURL);
    }

    private String removedTrailSlash(final String originURL) {
        if (originURL.endsWith("/")) {
            return originURL.substring(0, originURL.length() - 1);
        }
        return originURL;
    }

    private void validateOriginURL(final String originURL) {
        try {
            final URL url = new URL(originURL);
            url.toURI();
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }
}
