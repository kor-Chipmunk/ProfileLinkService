package com.smilegate.urlshortner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    private String shortUrl;

    @Column(nullable = false, unique = true)
    private Long ticket;

    public ShortURL(
            final String originUrl
            , final String shortUrl
            , final Long ticket
    ) {
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
        this.ticket = ticket;
    }
}
