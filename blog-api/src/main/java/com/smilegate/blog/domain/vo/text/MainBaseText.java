package com.smilegate.blog.domain.vo.text;

public class MainBaseText extends BaseText {
    private static final int MAX_LENGTH = 24;

    public MainBaseText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
