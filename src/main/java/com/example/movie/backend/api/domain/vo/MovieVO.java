package com.example.movie.backend.api.domain.vo;

import com.example.movie.backend.api.domain.entity.CastEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieVO {

    private long movieId;
    private String title;
    private LocalDate releaseDate;
    private String ageRating;
    private String genre;
    private Integer runtime;
    private BigDecimal rating;
    private String overview;
    private String subDescription;
    private String story;
    private String director;
    private String imageUrl;
    private List<CastEntity> castEntity;

    @Builder
    public MovieVO(long movieId, String title, LocalDate releaseDate, String ageRating, String genre,
                 Integer runtime, BigDecimal rating, String overview, String subDescription,
                 String story, String director, String imageUrl, List<CastEntity> castEntity) {
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.genre = genre;
        this.runtime = runtime;
        this.rating = rating;
        this.overview = overview;
        this.subDescription = subDescription;
        this.story = story;
        this.director = director;
        this.imageUrl = imageUrl;
        this.castEntity = castEntity;
    }
}
