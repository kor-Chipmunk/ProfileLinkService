package com.smilegate.bio.controller;

import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.service.RedirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class RedirectionController {
    private final RedirectionService redirectionService;

    @GetMapping("{id}")
    public RedirectView redirectOriginURL(@PathVariable("id") Long id) {
        final ShortURLDTO shortURLDTO = redirectionService.getShortURLById(id);
        final String originURL = shortURLDTO.originUrl();

        final RedirectView redirectView = new RedirectView(originURL);
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
}
