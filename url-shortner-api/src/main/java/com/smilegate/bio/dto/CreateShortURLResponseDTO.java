package com.smilegate.bio.dto;

import com.smilegate.bio.entity.ShortURL;

public record CreateShortURLResponseDTO(
        String originUrl,
        String shortUrl
) {

    public static CreateShortURLResponseDTO from(final ShortURL shortURL) {
        return new CreateShortURLResponseDTO(
                shortURL.getOriginUrl(),
                shortURL.getShortUrl()
        );
    }

}
