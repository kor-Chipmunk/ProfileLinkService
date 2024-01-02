package com.smilegate.blog.domain.vo.text;

import java.util.Objects;
import lombok.Getter;

@Getter
public abstract class BaseText {

    private final String text;

    protected BaseText(final String text) {
        validateLength(text);

        this.text = text;
    }

    protected void validateLength(final String text) {
        Objects.requireNonNull(text);

        final int maxLength = getMaxLength();
        if (text.length() > maxLength) {
            throw new IllegalArgumentException(maxLength + " 글자수를 넘길 수 없습니다.");
        }
    }

    abstract int getMaxLength();
}
