package com.smilegate.ticket.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.smilegate.ticket.dto.TicketIssueResponseDTO;
import com.smilegate.ticket.entity.Ticket;
import com.smilegate.ticket.repository.TicketRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketIssueServiceTest {
    @InjectMocks
    private TicketIssueService ticketIssueService;

    @Mock
    private TicketRepository ticketRepository;

    @Test
    @DisplayName("티켓을 발행합니다.")
    void Should_Create_Ticket_When_Issue() {
        //given
        final Ticket expectedTicket = new Ticket(1L);
        final TicketIssueResponseDTO expected = new TicketIssueResponseDTO(1L);

        //when
        when(ticketRepository.save(any())).thenReturn(expectedTicket);
        final TicketIssueResponseDTO actual = ticketIssueService.issue();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
