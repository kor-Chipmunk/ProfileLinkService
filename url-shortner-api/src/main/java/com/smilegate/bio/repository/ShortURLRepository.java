package com.smilegate.bio.repository;

import com.smilegate.bio.entity.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortURLRepository extends JpaRepository<ShortURL, Long> {
}
