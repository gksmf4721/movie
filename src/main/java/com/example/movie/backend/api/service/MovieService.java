package com.example.movie.backend.api.service;

import com.example.movie.backend.api.domain.dto.MovieDTO;
import com.example.movie.backend.api.domain.entity.CastEntity;
import com.example.movie.backend.api.domain.entity.MovieEntity;
import com.example.movie.backend.api.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieDTO.MovieDetailResponse getMovieDetail(long movieId) {

        MovieEntity movieEntity = movieRepository.findByMovieId(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // LazyException -> 서비스 메서드에서 cast 컬렉션을 직접 접근하여 초기화
        movieEntity.getCast().size();
        movieEntity.getCredit().size();
        movieEntity.getReview().size();
        movieEntity.getDiscussion().size();

        MovieDTO.MovieDetailResponse response = MovieDTO.MovieDetailResponse.of(movieEntity);

        return response;
    }
}
