package com.smilegate.bio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.CreateShortURLResponseDTO;
import com.smilegate.bio.entity.ShortURL;
import com.smilegate.bio.repository.ShortURLRepository;
import com.smilegate.bio.util.Base62Util;
import java.util.Optional;
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

        final ShortURL expectedShortURL = new ShortURL(originURL, Base62Util.from(1L));

        final CreateShortURLResponseDTO expected = CreateShortURLResponseDTO.from(expectedShortURL);

        //when
        when(shortURLRepository.findByOriginUrl(any())).thenReturn(Optional.empty());
        when(shortURLRepository.save(any())).thenReturn(expectedShortURL);

        final CreateShortURLResponseDTO actual = shortURLService.getOrCreateShortURL(request);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("원래 주소로 이미 단축한 경우 기존 단축 주소를 반환합니다.")
    void Should_Return_Exist_Short_URL_When_Origin_URL_Exist() {
        //given
        final String originURL = "https://www.naver.com";
        final CreateShortURLRequestDTO request = new CreateShortURLRequestDTO(originURL);

        final ShortURL expectedShortURL = new ShortURL(originURL, Base62Util.from(1L));

        final CreateShortURLResponseDTO expected = CreateShortURLResponseDTO.from(expectedShortURL);

        //when
        when(shortURLRepository.findByOriginUrl(any())).thenReturn(Optional.of(expectedShortURL));

        final CreateShortURLResponseDTO actual = shortURLService.getOrCreateShortURL(request);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("원래 주소 마지막에 슬래시(/)가 붙을 시 제거하여 저장합니다.")
    void Should_Remove_Trail_Slash_When_Origin_URL_Ends_With_Slash() {
        //given
        final String originURLWithSlash = "https://www.naver.com/";
        final CreateShortURLRequestDTO request = new CreateShortURLRequestDTO(originURLWithSlash);

        final String originURLWithoutSlash = "https://www.naver.com";
        final ShortURL expectedShortURL = new ShortURL(originURLWithoutSlash, Base62Util.from(1L));

        final CreateShortURLResponseDTO expected = CreateShortURLResponseDTO.from(expectedShortURL);

        //when
        when(shortURLRepository.findByOriginUrl(any())).thenReturn(Optional.empty());
        when(shortURLRepository.save(any())).thenReturn(expectedShortURL);

        final CreateShortURLResponseDTO actual = shortURLService.getOrCreateShortURL(request);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
