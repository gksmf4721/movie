package com.example.movie.backend.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Getter
@Table(name = "M_CAST")
public class CastEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAST_ID")
    private long castId;

    @Column(name = "ACTOR_NAME_KR", nullable = false)
    private String actorNameKr;

    @Column(name = "ACTOR_NAME_EN", nullable = false)
    private String actorNameEn;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    @JsonBackReference  // 양방향 관계의 다른 쪽에서만 직렬화
    private MovieEntity movieEntity;
}
