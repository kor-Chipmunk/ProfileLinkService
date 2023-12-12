package com.smilegate.urlshortner.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    private static final long RESPONSE_TIMEOUT_MILLIS = 1000L;

    @Value("${webclient.ticket.baseurl}")
    private String ticketBaseURL;

    @Bean(name = "ticket")
    public WebClient ticketWebClient() {
        final HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofMillis(RESPONSE_TIMEOUT_MILLIS));

        return WebClient.builder()
                .baseUrl(ticketBaseURL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
