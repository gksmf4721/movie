package com.example.movie.backend.api.repository;

import com.example.movie.backend.api.domain.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {

    // 영화 상세 조회
    Optional<MovieEntity> findByMovieId(long movieId);
}
