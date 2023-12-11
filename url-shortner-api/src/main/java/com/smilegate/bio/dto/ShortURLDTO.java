package com.smilegate.bio.dto;

import com.smilegate.bio.entity.ShortURL;

public record ShortURLDTO(
        Long id,
        String originUrl,
        String shortUrl
) {

    public static ShortURLDTO from(final ShortURL shortURL) {
        return new ShortURLDTO(
                shortURL.getId(),
                shortURL.getOriginUrl(),
                shortURL.getShortURL()
        );
    }

}
