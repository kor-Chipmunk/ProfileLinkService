package com.smilegate.blog.domain.vo.text;

public class TelephoneBaseText extends BaseText {
    private static final int MAX_LENGTH = 60;

    public TelephoneBaseText(final String text) {
        super(text);
    }

    @Override
    int getMaxLength() {
        return MAX_LENGTH;
    }
}
