package com.smilegate.bio.util;

public class Base62Util {

    private static final int MAX_LENGTH = 8;
    private static final int RADIX = 62;

    private static final char[] SCHEMES = new char[] {
            'V', 'y', 'x', 'l', 'Q', 'L', 'N', 'S', 'O', '9',
            'H', 'T', '8', 'J', 'u', 'i', 'X', 'D', 'K', 'c',
            '7', 'h', 'F', 'a', '3', 'b', 'o', '5', 'g', 'M',
            'f', 'E', 'W', 'Z', '2', 'R', 'p', '6', 'G', 'q',
            'v', 'r', 'k', '1', 'U', 'n', 'P', 'w', 'e', 't',
            '0', 'm', 'B', 'Y', 'C', '4', 'j', 'd', 'I', 'z',
            'A', 's'
    };

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
