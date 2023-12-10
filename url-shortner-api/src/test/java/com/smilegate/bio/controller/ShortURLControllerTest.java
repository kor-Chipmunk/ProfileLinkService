package com.smilegate.bio.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smilegate.bio.dto.CreateShortURLRequestDTO;
import com.smilegate.bio.dto.CreateShortURLResponseDTO;
import com.smilegate.bio.service.ShortURLService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ShortURLController.class)
class ShortURLControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    private ShortURLService service;

    @Test
    @DisplayName("단축 주소를 생성합니다.")
    void Should_Create_Short_URL_When_Origin_URL_Serve() throws Exception {
        //given
        final String originURL = "https://www.naver.com";
        final CreateShortURLRequestDTO request = new CreateShortURLRequestDTO(originURL);

        //when
        final CreateShortURLResponseDTO mockResponse = new CreateShortURLResponseDTO("1", originURL);
        when(service.getOrCreateShortURL(any())).thenReturn(mockResponse);

        //then
        mockMvc.perform(
                post("/shorts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shortUrl").value("1"))
                .andExpect(jsonPath("$.originUrl").value(originURL))
                .andDo(print());
    }
}
