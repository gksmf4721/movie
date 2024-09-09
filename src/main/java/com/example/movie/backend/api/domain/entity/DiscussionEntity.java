package com.example.movie.backend.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "M_DISCUSSIONS")
@Builder
public class DiscussionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCUSSION_ID")
    private Long discussionId;

//    @Column(name = "MOVIE_ID", nullable = false)
//    private Long movieId;

    @Column(name = "DISCUSSION_TEXT", nullable = false, columnDefinition = "TEXT")
    private String discussionText;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    @JsonBackReference
    private MovieEntity movieEntity;
}
