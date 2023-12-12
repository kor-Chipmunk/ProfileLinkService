package com.smilegate.urlshortner.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smilegate.urlshortner.dto.TicketIssueResponseDTO;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

class TicketServiceTest {
    private static MockWebServer mockTickerServer;

    private static ObjectMapper objectMapper;

    private TicketService service;

    @BeforeAll
    static void setUp() throws IOException {
        mockTickerServer = new MockWebServer();
        objectMapper = new ObjectMapper();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockTickerServer.shutdown();
    }

    @BeforeEach
    void initialize() {
        final String baseUrl = String.format("http://localhost:%s",
                mockTickerServer.getPort());
        service = new TicketService(
                WebClient
                        .builder()
                        .baseUrl(baseUrl)
                        .clientConnector(new ReactorClientHttpConnector())
                        .build()
        );
    }

    @Test
    @DisplayName("티켓 서버에서 티켓을 발행합니다.")
    void Should_Issue_Ticket_From_Ticket_Server() throws JsonProcessingException {
        //given
        final TicketIssueResponseDTO expected = new TicketIssueResponseDTO(1L);

        //when
        mockTickerServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(expected))
                .addHeader("Content-Type", "application/json"));

        final TicketIssueResponseDTO actual = service.issue();

        //then
        assertThat(actual).isEqualTo(expected);
    }

}