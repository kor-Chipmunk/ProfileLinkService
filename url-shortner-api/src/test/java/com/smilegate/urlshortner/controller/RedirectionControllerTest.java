package com.smilegate.urlshortner.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.smilegate.urlshortner.dto.ShortURLDTO;
import com.smilegate.urlshortner.service.RedirectionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RedirectionController.class)
class RedirectionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedirectionService service;

    @Test
    @DisplayName("단축 주소로 접속 시 원래 주소로 이동합니다.")
    void Should_Redirect_To_ShortURL_When_Id_Serve() throws Exception {
        //given
        final String originURL = "https://www.naver.com";
        final ShortURLDTO mockShortURLDTO = new ShortURLDTO(1L, originURL, "1");

        //when
        when(service.getShortURLByShortUrl(any())).thenReturn(mockShortURLDTO);

        //then
        mockMvc
                .perform(get("/1"))
                .andExpect(status().isPermanentRedirect())
                .andExpect(redirectedUrl(originURL))
                .andDo(print());
    }

}
