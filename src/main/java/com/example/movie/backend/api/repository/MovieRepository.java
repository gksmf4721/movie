package com.example.movie.backend.api.repository;

import com.example.movie.backend.api.domain.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {

    // 영화 상세 조회
    Optional<MovieEntity> findByMovieId(long movieId);
}
