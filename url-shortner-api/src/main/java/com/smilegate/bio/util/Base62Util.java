package com.smilegate.bio.util;

public class Base62Util {

    private static final int MAX_LENGTH = 8;
    private static final int RADIX = 62;

    private static final char[] SCHEMES;

    static {
        SCHEMES = new char[RADIX];

        for (int i = 0; i < 10; i++) {
            SCHEMES[i] = (char) ('0' + i);
        }

        for (int i = 0; i < 26; i++) {
            SCHEMES[10 + i] = (char) ('A' + i);
        }

        for (int i = 0; i < 26; i++) {
            SCHEMES[36 + i] = (char) ('a' + i);
        }
    }

    private Base62Util() {
        // No Instances
    }

    public static String from(long id) {
        StringBuilder builder = new StringBuilder(MAX_LENGTH);

        while (id > 0) {
            builder.append(SCHEMES[(int) (id % RADIX)]);
            id /= RADIX;
        }

        return builder.toString();
    }
}
