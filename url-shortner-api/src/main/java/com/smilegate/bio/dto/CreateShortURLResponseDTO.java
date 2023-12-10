package com.smilegate.bio.dto;

import com.smilegate.bio.entity.ShortURL;

public record CreateShortURLResponseDTO(
        String shortUrl,
        String originUrl
) {

    public static CreateShortURLResponseDTO from(final ShortURL shortURL) {
        return new CreateShortURLResponseDTO(
                shortURL.getShortURL(),
                shortURL.getOriginUrl()
        );
    }

}
