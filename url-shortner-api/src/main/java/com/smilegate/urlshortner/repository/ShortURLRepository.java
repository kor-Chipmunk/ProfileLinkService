package com.smilegate.urlshortner.repository;

import com.smilegate.urlshortner.entity.ShortURL;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortURLRepository extends JpaRepository<ShortURL, Long> {
    Optional<ShortURL> findByOriginUrl(String originUrl);
    Optional<ShortURL> findByShortUrl(String shortUrl);

    Optional<ShortURL> findTopByOrderByIdDesc();
}
