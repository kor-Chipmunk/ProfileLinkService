package com.smilegate.blog.domain.vo.text;

public class SubBaseText extends BaseText {
    private static final int MAX_LENGTH = 1_000;

    public SubBaseText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
