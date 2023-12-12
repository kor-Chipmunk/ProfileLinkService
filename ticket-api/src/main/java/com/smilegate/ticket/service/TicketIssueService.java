package com.smilegate.ticket.service;

import com.smilegate.ticket.dto.TicketIssueResponseDTO;
import com.smilegate.ticket.entity.Ticket;
import com.smilegate.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketIssueService {
    private final TicketRepository repository;

    @Transactional
    public TicketIssueResponseDTO issue() {
        final Ticket createdTicket = repository.save(new Ticket());
        return new TicketIssueResponseDTO(createdTicket.getId());
    }
}
