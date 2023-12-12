package com.smilegate.ticket.controller;

import com.smilegate.ticket.dto.TicketIssueResponseDTO;
import com.smilegate.ticket.service.TicketIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketIssueController {
    private final TicketIssueService service;

    @PostMapping
    public ResponseEntity<TicketIssueResponseDTO> issue() {
        final TicketIssueResponseDTO response = service.issue();
        return ResponseEntity.ok(response);
    }
}
