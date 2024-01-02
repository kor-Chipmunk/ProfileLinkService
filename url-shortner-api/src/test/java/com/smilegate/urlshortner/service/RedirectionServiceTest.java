package com.smilegate.urlshortner.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.smilegate.urlshortner.dto.ShortURLDTO;
import com.smilegate.urlshortner.entity.ShortURL;
import com.smilegate.urlshortner.repository.ShortURLRepository;
import com.smilegate.urlshortner.util.Base62Util;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RedirectionServiceTest {
    @InjectMocks
    private RedirectionService redirectionService;

    @Mock
    private ShortURLRepository shortURLRepository;

    @Test
    @DisplayName("단축 주소 요청으로 엔티티를 조회합니다.")
    void Should_Get_Short_URL_When_Short_URL_Serve() {
        //given
        final String originURL = "https://www.naver.com";
        final String shortURL = Base62Util.encode(1L);

        final ShortURL expectedShortURL = new ShortURL(originURL, shortURL, 1L);
        when(shortURLRepository.findByTicket(any())).thenReturn(Optional.of(expectedShortURL));

        final ShortURLDTO expected = ShortURLDTO.from(expectedShortURL);

        //when
        final ShortURLDTO actual = redirectionService.getShortURLByShortUrl(shortURL);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("단축 주소 조회가 불가능한 경우 예외를 발생합니다.")
    void Should_Throw_Exception_When_Short_Url_Not_Found() {
        //given
        final String originURL = "https://www.naver.com";
        final String shortURL = Base62Util.encode(1L);

        final ShortURL expectedShortURL = new ShortURL(originURL, shortURL, 1L);

        //when,then
        assertThatThrownBy(() -> redirectionService.getShortURLByShortUrl(shortURL));
    }
}
