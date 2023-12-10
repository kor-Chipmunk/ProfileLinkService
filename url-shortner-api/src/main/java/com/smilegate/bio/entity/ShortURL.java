package com.smilegate.bio.entity;

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

    public ShortURL(
            final Long id,
            final String originUrl
    ) {
        this.id = id;
        this.originUrl = originUrl;
    }

    public ShortURL(final String originUrl) {
        this.originUrl = originUrl;
    }

    public String getShortURL() {
        return id.toString();
    }
}
