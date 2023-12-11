package com.smilegate.bio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Getter
public class ShortURL extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String originUrl;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    public ShortURL(final String originUrl, final String shortUrl) {
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
    }
}
