package com.example.movie.backend.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "M_MOVIES")
@Builder
@DynamicInsert
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "AGE_RATING", nullable = false)
    private String ageRating;

    @Column(name = "GENRE", nullable = false)
    private String genre;

    @Column(name = "RUNTIME", nullable = false)
    private Integer runtime;

    @Column(name = "RATING", nullable = false)
    private BigDecimal rating;

    @Column(name = "OVERVIEW")
    private String overview;

    @Column(name = "SUB_DESCRIPTION")
    private String subDescription;

    @Column(name = "STORY")
    private String story;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany(mappedBy = "movieEntity", fetch = FetchType.LAZY)
    @JsonManagedReference  // 양방향 관계의 한쪽 방향에서만 직렬화
    private List<CastEntity> cast;

    @OneToMany(mappedBy = "movieEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CreditEntity> credit;

    @OneToMany(mappedBy = "movieEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ReviewEntity> review;

    @OneToMany(mappedBy = "movieEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DiscussionEntity> discussion;

}
