package com.smilegate.bio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
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
    @DisplayName("아이디로 단축 주소 엔티티를 조회합니다.")
    void Should_Get_Short_URL_When_Id_Serve() {
        //given
        final String originURL = "https://www.naver.com";

        final ShortURL expectedShortURL = new ShortURL(originURL);
        when(shortURLRepository.findById(any())).thenReturn(Optional.of(expectedShortURL));

        final Long shortUrlId = expectedShortURL.getId();
        final ShortURLDTO expected = ShortURLDTO.from(expectedShortURL);

        //when
        final ShortURLDTO actual = redirectionService.getShortURLById(shortUrlId);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("조회가 불가능한 경우 예외를 발생합니다.")
    void Should_Throw_Exception_When_Id_Not_Found() {
        //given
        final String originURL = "https://www.naver.com";

        final ShortURL expectedShortURL = new ShortURL(originURL);
        final Long shortUrlId = expectedShortURL.getId();

        //when,then
        assertThatThrownBy(() -> redirectionService.getShortURLById(shortUrlId));
    }
}
