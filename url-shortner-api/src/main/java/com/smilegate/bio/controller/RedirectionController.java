package com.smilegate.bio.controller;

import com.smilegate.bio.dto.ShortURLDTO;
import com.smilegate.bio.service.RedirectionService;
import com.smilegate.bio.service.ShortURLService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class RedirectionController {
    private final RedirectionService redirectionService;

    @GetMapping("{id}")
    public void redirectOriginURL(
            HttpServletResponse response,
            @PathVariable("id") Long id
    ) throws IOException {
        final ShortURLDTO shortURLDTO = redirectionService.getShortURLById(id);
        final String originURL = shortURLDTO.originUrl();
        response.sendRedirect(originURL);
    }
}
