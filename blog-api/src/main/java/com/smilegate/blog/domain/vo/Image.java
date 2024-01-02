package com.smilegate.blog.domain.vo;

import java.util.Objects;

public record Image(Link link) {
    public Image {
        validateLink(link);
    }

    private void validateLink(final Link link) {
        Objects.requireNonNull(link);
    }
}
