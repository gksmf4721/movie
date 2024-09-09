package com.example.movie.backend.api.domain.dto;

import com.example.movie.backend.api.domain.entity.*;
import com.example.movie.backend.api.domain.vo.MovieVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieDTO {

    @Getter
    @Builder
    public static class MovieDetailResponse {

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

        private List<CastResponse> castList;
        private List<CreditResponse> creditList;
        private List<ReviewResponse> reviewList;
        private List<DiscussionResponse> discussionList;

        public static MovieDetailResponse of(MovieEntity movie) {
            return MovieDetailResponse.builder()
                    .movieId(movie.getMovieId())
                    .title(movie.getTitle())
                    .releaseDate(movie.getReleaseDate())
                    .ageRating(movie.getAgeRating())
                    .genre(movie.getGenre())
                    .runtime(movie.getRuntime())
                    .rating(movie.getRating())
                    .overview(movie.getOverview())
                    .subDescription(movie.getSubDescription())
                    .story(movie.getStory())
                    .director(movie.getDirector())
                    .imageUrl(movie.getImageUrl())
                    .castList(movie.getCast().stream().map(CastResponse::of).collect(Collectors.toList()))
                    .creditList(movie.getCredit().stream().map(CreditResponse::of).collect(Collectors.toList()))
                    .reviewList(movie.getReview().stream().map(ReviewResponse::of).collect(Collectors.toList()))
                    .discussionList(movie.getDiscussion().stream().map(DiscussionResponse::of).collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CastResponse {

        private long castId;
        private String actorNameKr;
        private String actorNameEn;
        private String imageUrl;

        public static CastResponse of(CastEntity cast) {
            return CastResponse.builder()
                    .castId(cast.getCastId())
                    .actorNameKr(cast.getActorNameKr())
                    .actorNameEn(cast.getActorNameEn())
                    .imageUrl(cast.getImageUrl())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CreditResponse {

        private long creditId;
        private String role;
        private String personName;
        private int position;

        public static CreditResponse of(CreditEntity credit) {
            return CreditResponse.builder()
                    .creditId(credit.getCreditId())
                    .role(credit.getRole())
                    .personName(credit.getPersonName())
                    .position(credit.getPosition())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ReviewResponse {

        private long reviewId;
        private String reviewText;

        public static ReviewResponse of(ReviewEntity review) {
            return ReviewResponse.builder()
                    .reviewId(review.getReviewId())
                    .reviewText(review.getReviewText())
                    .build();
        }
    }


    @Getter
    @Builder
    public static class DiscussionResponse {

        private long discussionId;
        private String discussionText;

        public static DiscussionResponse of(DiscussionEntity discussion) {
            return DiscussionResponse.builder()
                    .discussionId(discussion.getDiscussionId())
                    .discussionText(discussion.getDiscussionText())
                    .build();
        }
    }




}
