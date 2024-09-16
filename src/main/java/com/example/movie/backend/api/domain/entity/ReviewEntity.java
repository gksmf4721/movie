package com.example.movie.backend.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "M_REVIEWS")
@Builder
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @Column(name = "REVIEW_TEXT", nullable = false, columnDefinition = "TEXT")
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    @JsonBackReference
    private MovieEntity movieEntity;
}
