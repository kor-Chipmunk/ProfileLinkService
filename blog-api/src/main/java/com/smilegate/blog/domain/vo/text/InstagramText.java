package com.smilegate.blog.domain.vo.text;

public class InstagramText extends BaseText {
    private static final int MAX_LENGTH = 30;

    public InstagramText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
