package com.smilegate.bio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShortURLServiceTest {
    @InjectMocks
    private ShortURLService shortURLService;

    @Mock
    private ShortURLRepository shortURLRepository;

    @Test
    @DisplayName("원래 주소가 담긴 단축 주소를 생성합니다.")
    void Should_Create_Short_URL_When_Origin_URL_Serve() {
        //given
        final String originURL = "https://www.naver.com";
        final CreateShortURLRequestDTO request = new CreateShortURLRequestDTO(originURL);

        final ShortURL expectedShortURL = new ShortURL(originURL);
        when(shortURLRepository.save(any())).thenReturn(expectedShortURL);

        final ShortURLDTO expected = ShortURLDTO.from(expectedShortURL);

        //when
        final ShortURLDTO actual = shortURLService.createShortURL(request);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
