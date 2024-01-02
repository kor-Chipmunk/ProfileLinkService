package com.smilegate.urlshortner.controller;

import com.smilegate.urlshortner.dto.ShortURLDTO;
import com.smilegate.urlshortner.service.RedirectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class RedirectionController {
    private final Logger logger = LoggerFactory.getLogger(RedirectionController.class);

    private final RedirectionService redirectionService;
    private final Environment environment;

    @GetMapping("{id}")
    public RedirectView redirectOriginURL(@PathVariable("id") String shortUrl) {
        String originURL = environment.getProperty("redirect.web.baseurl");

        try {
            final ShortURLDTO shortURLDTO = redirectionService.getShortURLByShortUrl(shortUrl);
            originURL = shortURLDTO.originUrl();
        } catch (RuntimeException exception) {
            logger.warn(String.format("찾을 수 없는 단축 주소를 요청했습니다. - %s", shortUrl));
        }

        final RedirectView redirectView = new RedirectView(originURL);
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
}
