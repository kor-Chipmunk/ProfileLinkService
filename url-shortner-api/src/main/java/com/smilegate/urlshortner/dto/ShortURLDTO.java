package com.smilegate.urlshortner.dto;

import com.smilegate.urlshortner.entity.ShortURL;

public record ShortURLDTO(
        Long id,
        String originUrl,
        String shortUrl
) {

    public static ShortURLDTO from(final ShortURL shortURL) {
        return new ShortURLDTO(
                shortURL.getId(),
                shortURL.getOriginUrl(),
                shortURL.getShortUrl()
        );
    }

}
