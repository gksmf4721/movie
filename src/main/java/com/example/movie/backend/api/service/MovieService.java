package com.example.movie.backend.api.service;

import com.example.movie.backend.api.domain.dto.MovieDTO;
import com.example.movie.backend.api.domain.entity.MovieEntity;
import com.example.movie.backend.api.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public MovieDTO.MovieDetailResponse getMovieDetail(long movieId) {

        MovieEntity movieEntity = movieRepository.findByMovieId(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        lazyReset(movieEntity);

        MovieDTO.MovieDetailResponse response = MovieDTO.MovieDetailResponse.of(movieEntity);

        return response;
    }


    @Transactional
    public MovieDTO.RecommendListResponse searchByGenres(long movieId) {

        // 1. 기준 영화 엔티티 조회
        MovieEntity movieEntity = movieRepository.findByMovieId(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // 2. lazyReset 호출 (사용자 정의 메소드, 필요에 따라 유지)
        lazyReset(movieEntity);

        // 3. 장르 문자열을 쉼표로 분리하고 공백 제거
        String[] genreArray = movieEntity.getGenre().split(",");
        Set<String> baseGenres = Arrays.stream(genreArray)
                .map(String::trim)
                .filter(genre -> !genre.isEmpty())
                .collect(Collectors.toSet());

        // 4. CriteriaBuilder와 CriteriaQuery 객체 생성
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MovieEntity> cq = cb.createQuery(MovieEntity.class);
        Root<MovieEntity> movie = cq.from(MovieEntity.class);

        // 5. 장르 기반의 OR 조건 생성
        Predicate predicate = cb.disjunction(); // OR 조건
        for (String genre : baseGenres) {
            Predicate genrePredicate = cb.like(movie.get("genre"), "%" + genre + "%");
            predicate = cb.or(predicate, genrePredicate);
        }

        // 6. 제외할 movieId 조건 추가
        Predicate excludePredicate = cb.notEqual(movie.get("movieId"), movieId);
        predicate = cb.and(predicate, excludePredicate);

        // 7. 쿼리 조건 설정 및 실행
        cq.where(predicate);
        TypedQuery<MovieEntity> query = entityManager.createQuery(cq);
        List<MovieEntity> list = query.getResultList();

        // 8. 장르 일치도 계산 및 결과에 포함
        List<MovieDTO.RecommendResponse> recommendResponses = new ArrayList<>();
        for (MovieEntity m : list) {
            String[] movieGenresArray = m.getGenre().split(",");
            Set<String> movieGenres = Arrays.stream(movieGenresArray)
                    .map(String::trim)
                    .filter(genre -> !genre.isEmpty())
                    .collect(Collectors.toSet());

            // Calculate intersection size
            Set<String> intersection = new HashSet<>(baseGenres);
            intersection.retainAll(movieGenres);

            int matchCount = intersection.size();
            double matchPercentage = baseGenres.isEmpty() ? 0.0 : (matchCount / (double) baseGenres.size()) * 100;

            // RecommendResponse 객체 생성
            MovieDTO.RecommendResponse response = MovieDTO.RecommendResponse.of(m, matchPercentage);
            recommendResponses.add(response);
        }

        // 9. RecommendListResponse 객체 생성
        return MovieDTO.RecommendListResponse.of(recommendResponses);
    }

    private void lazyReset(MovieEntity movieEntity) {
        // LazyException -> 서비스 메서드에서 cast 컬렉션을 직접 접근하여 초기화
        movieEntity.getCast().size();
        movieEntity.getCredit().size();
        movieEntity.getReview().size();
        movieEntity.getDiscussion().size();
    }
}
