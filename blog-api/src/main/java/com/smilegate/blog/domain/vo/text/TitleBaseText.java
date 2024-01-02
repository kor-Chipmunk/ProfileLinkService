package com.smilegate.blog.domain.vo.text;

public class TitleBaseText extends BaseText {
    private static final int MAX_LENGTH = 60;

    public TitleBaseText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
