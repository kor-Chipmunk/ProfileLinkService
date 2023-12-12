package com.smilegate.urlshortner.service;

import com.smilegate.urlshortner.dto.CreateShortURLRequestDTO;
import com.smilegate.urlshortner.dto.CreateShortURLResponseDTO;
import com.smilegate.urlshortner.dto.TicketIssueResponseDTO;
import com.smilegate.urlshortner.entity.ShortURL;
import com.smilegate.urlshortner.repository.ShortURLRepository;
import com.smilegate.urlshortner.util.Base62Util;
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
    private final TicketService ticketService;

    @Transactional
    public CreateShortURLResponseDTO getOrCreateShortURL(final CreateShortURLRequestDTO request) {
        final String originURL = removedTrailSlash(request.originUrl());
        validateOriginURL(originURL);

        final Optional<ShortURL> retrievalShortURL = shortURLRepository.findByOriginUrl(originURL);
        if (retrievalShortURL.isPresent()) {
            return CreateShortURLResponseDTO.from(retrievalShortURL.get());
        }

        final TicketIssueResponseDTO ticketResponseDTO = ticketService.issue();
        final long issueId = ticketResponseDTO.issueId();

        final ShortURL shortURLEntity = new ShortURL(request.originUrl(), Base62Util.from(issueId));
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
