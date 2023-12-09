package com.smilegate.bio.dto;

import com.smilegate.bio.entity.ShortURL;

public record ShortURLDTO(
        Long id,
        String originUrl
) {

    public static ShortURLDTO from(ShortURL shortURL) {
        return new ShortURLDTO(
                shortURL.getId(),
                shortURL.getOriginUrl()
        );
    }

}
