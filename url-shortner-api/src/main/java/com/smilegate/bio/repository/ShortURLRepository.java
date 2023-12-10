package com.smilegate.bio.repository;

import com.smilegate.bio.entity.ShortURL;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortURLRepository extends JpaRepository<ShortURL, Long> {
    Optional<ShortURL> findByOriginUrl(String originUrl);
}
