package com.smilegate.blog.domain.vo;

import java.net.MalformedURLException;
import java.net.URL;

public record Link(String url) {
    public Link {
        validateURLFormat(url);
    }

    private void validateURLFormat(final String url) {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
