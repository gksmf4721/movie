package com.example.movie.backend.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "M_CREDITS")
@Builder
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CREDIT_ID")
    private Long creditId;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "PERSON_NAME", nullable = false)
    private String personName;

    @Column(name = "POSITION", nullable = false)
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    @JsonBackReference
    private MovieEntity movieEntity;
}