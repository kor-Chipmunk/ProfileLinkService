package com.smilegate.blog.domain.vo.text;

public class ContentBaseText extends BaseText {
    private static final int MAX_LENGTH = 1_000;

    public ContentBaseText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
