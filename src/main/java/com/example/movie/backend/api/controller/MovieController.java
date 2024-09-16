package com.example.movie.backend.api.controller;

import com.example.movie.backend.api.domain.dto.MovieDTO;
import com.example.movie.backend.api.domain.entity.MovieEntity;
import com.example.movie.backend.api.service.MovieService;
import com.example.movie.backend.common.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
@RestController
public class MovieController {

    private final MovieService movieService;

    // 영화 상세 조회
    @GetMapping(value="/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<MovieDTO.MovieDetailResponse>> getMovieDetail(@RequestParam("movieId") long movieId) {

        MovieDTO.MovieDetailResponse response = movieService.getMovieDetail(movieId);

        return ResponseEntity.ok(new RestResponse<>(response));
    }

    // 영화 추천 조회
    @GetMapping(value = "/recommend", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<MovieDTO.RecommendListResponse>> getMovieRecommend(@RequestParam("movieId") long movieId) {

        MovieDTO.RecommendListResponse response = movieService.searchByGenres(movieId);

        return ResponseEntity.ok(new RestResponse<>(response));
    }

}
