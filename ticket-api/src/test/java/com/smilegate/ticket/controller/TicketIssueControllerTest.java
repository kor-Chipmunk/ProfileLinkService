package com.smilegate.ticket.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smilegate.ticket.dto.TicketIssueResponseDTO;
import com.smilegate.ticket.service.TicketIssueService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TicketIssueController.class)
class TicketIssueControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketIssueService service;

    @Test
    @DisplayName("티켓을 발행합니다.")
    void Should_Create_Issue() throws Exception {
        //given
        //when
        final TicketIssueResponseDTO mockResponse = new TicketIssueResponseDTO(1L);
        when(service.issue()).thenReturn(mockResponse);

        //then
        mockMvc.perform(
                        post("/ticket")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.issueId").value("1"))
                .andDo(print());
    }

}
