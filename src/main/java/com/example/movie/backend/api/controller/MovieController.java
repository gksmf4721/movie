package com.example.movie.backend.api.controller;

import com.example.movie.backend.api.domain.dto.MovieDTO;
import com.example.movie.backend.api.domain.entity.MovieEntity;
import com.example.movie.backend.api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MovieController {

    private final MovieService movieService;

    // 영화 상세 조회
    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO.MovieDetailResponse> getMovieDetail(@RequestParam("movieId") long movieId) {

        MovieDTO.MovieDetailResponse response = movieService.getMovieDetail(movieId);

        return ResponseEntity.ok(response);
    }
}
