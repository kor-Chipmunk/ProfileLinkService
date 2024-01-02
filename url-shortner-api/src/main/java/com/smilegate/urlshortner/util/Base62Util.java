package com.smilegate.urlshortner.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    private static final Map<Character, Integer> DECODE_SCHEMES = new HashMap<>();
    static {
        for (int idx = 0; idx < SCHEMES.length; idx++) {
            DECODE_SCHEMES.put(SCHEMES[idx], idx);
        }
    }

    private Base62Util() {
        // No Instances
    }

    public static String encode(long id) {
        final StringBuilder builder = new StringBuilder(MAX_LENGTH);

        while (id > 0) {
            builder.append(SCHEMES[(int) (id % RADIX)]);
            id /= RADIX;
        }

        return builder.toString();
    }

    public static long decode(String encrypted) {
        validateEncrypted(encrypted);

        long decrypted = 0;
        int pow = 0;

        for (char scheme : encrypted.toCharArray()) {
            int schemeIndex = DECODE_SCHEMES.get(scheme);
            decrypted += (long) (Math.pow(RADIX, pow) * schemeIndex);
            pow++;
        }

        return decrypted;
    }

    private static void validateEncrypted(String encrypted) {
        Objects.requireNonNull(encrypted);
        if (encrypted.isBlank()) {
            throw new IllegalArgumentException("빈 값을 복호화할 수 없습니다.");
        }
    }
}
