package com.smilegate.urlshortner.dto;

import com.smilegate.urlshortner.entity.ShortURL;

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
