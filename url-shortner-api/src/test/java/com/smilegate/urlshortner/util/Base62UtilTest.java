package com.smilegate.urlshortner.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Base62UtilTest {
    @ParameterizedTest
    @CsvSource(value = {"10:H" , "100000:jVo", "100000000:uRpwN"}, delimiter = ':')
    @DisplayName("62진법으로 고유 번호를 문자열로 변환합니다.")
    void Should_Base62_Encryption_When_Id_Serve(long id, String expected) {
        //given
        //when
        final String actual = Base62Util.from(id);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
