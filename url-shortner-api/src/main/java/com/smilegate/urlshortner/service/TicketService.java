package com.smilegate.urlshortner.service;

import com.smilegate.urlshortner.dto.TicketIssueResponseDTO;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TicketService {
    private final WebClient client;

    public TicketService(@Qualifier("ticket") final WebClient client) {
        this.client = client;
    }

    public TicketIssueResponseDTO issue() {
        return client
                .post()
                .uri("/ticket")
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> Mono.error(new RuntimeException("티켓 발행에 오류가 발생했습니다."))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        clientResponse -> Mono.error(new RuntimeException("티켓 서버가 응답하지 않습니다."))
                )
                .bodyToMono(TicketIssueResponseDTO.class)
                .block();
    }
}
