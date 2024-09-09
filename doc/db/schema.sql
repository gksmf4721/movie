-- movie_db.movies definition

CREATE TABLE `M_MOVIES` (
                            `MOVIE_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '영화_시퀀스',
                            `TITLE` VARCHAR(255) NOT NULL COMMENT '영화_제목',
                            `RELEASE_DATE` DATE NOT NULL COMMENT '개봉_일자',
                            `AGE_RATING` VARCHAR(10) NOT NULL COMMENT '연령_등급',
                            `GENRE` VARCHAR(100) NOT NULL COMMENT '영화_장르',
                            `RUNTIME` INT(10) NOT NULL COMMENT '러닝타임(분)',
                            `RATING` DECIMAL(3,2) NOT NULL COMMENT '평가_점수',
                            `OVERVIEW` TEXT COMMENT '영화_개요',
                            `SUB_DESCRIPTION` TEXT COMMENT '서브_설명',
                            `STORY` TEXT COMMENT '영화_스토리',
                            `DIRECTOR` VARCHAR(255) COMMENT '감독',
                            `IMAGE_URL` VARCHAR(255) COMMENT '영화_포스터_URL',
                            PRIMARY KEY (`MOVIE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화';

-- movie_db.credits definition

CREATE TABLE `M_CREDITS` (
                             `CREDIT_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '크레딧_시퀀스',
                             `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                             `ROLE` VARCHAR(50) NOT NULL COMMENT '역할_타입',
                             `PERSON_NAME` VARCHAR(255) NOT NULL COMMENT '인물_이름',
                             `POSITION` INT(10) NOT NULL COMMENT '역할_순서',
                             PRIMARY KEY (`CREDIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_크레딧';

-- movie_db.cast definition

CREATE TABLE `M_CAST` (
                          `CAST_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '출연진_시퀀스',
                          `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                          `ACTOR_NAME_KR` VARCHAR(255) NOT NULL COMMENT '배우_이름_한글',
                          `ACTOR_NAME_EN` VARCHAR(255) NOT NULL COMMENT '배우_이름_영문',
                          `IMAGE_URL` VARCHAR(255) COMMENT '배우_이미지_URL',
                          PRIMARY KEY (`CAST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_출연진';

-- movie_db.reviews definition

CREATE TABLE `M_REVIEWS` (
                             `REVIEW_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '리뷰_시퀀스',
                             `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                             `REVIEW_TEXT` TEXT NOT NULL COMMENT '리뷰_내용',
                             PRIMARY KEY (`REVIEW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_리뷰';

-- movie_db.discussions definition

CREATE TABLE `M_DISCUSSIONS` (
                                 `DISCUSSION_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '토론_시퀀스',
                                 `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                                 `DISCUSSION_TEXT` TEXT NOT NULL COMMENT '토론_내용',
                                 PRIMARY KEY (`DISCUSSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_토론';














-- -----------------------------



INSERT INTO `M_MOVIES` (`MOVIE_ID`, `TITLE`, `RELEASE_DATE`, `AGE_RATING`, `GENRE`, `RUNTIME`, `RATING`, `OVERVIEW`, `SUB_DESCRIPTION`, `STORY`, `DIRECTOR`, `IMAGE_URL`)
VALUES
    (1, 'The Grand Adventure', '2024-01-15', 'PG-13', 'Action', 120, 8.5, 'An epic journey of a young hero.', 'A thrilling adventure across lands.', 'A young hero embarks on an epic journey to save his world from darkness.', 'Jane Doe', 'http://example.com/images/grand_adventure.jpg'),
    (2, 'Mystery of the Ancient Temple', '2023-11-22', 'PG', 'Adventure', 105, 7.8, 'A mysterious temple holds ancient secrets.', 'Discover the hidden truths.', 'A group of explorers unravels the mysteries of an ancient temple.', 'John Smith', 'http://example.com/images/ancient_temple.jpg');



INSERT INTO `M_CAST` (`CAST_ID`, `MOVIE_ID`, `ACTOR_NAME_KR`, `ACTOR_NAME_EN`, `IMAGE_URL`)
VALUES
    (1, 1, '김철수', 'Chul-Soo Kim', 'http://example.com/images/chulsoo_kim.jpg'),
    (2, 1, '이영희', 'Young-Hee Lee', 'http://example.com/images/younghee_lee.jpg'),
    (3, 2, '박지민', 'Ji-Min Park', 'http://example.com/images/jimin_park.jpg'),
    (4, 2, '오세훈', 'Se-Hoon Oh', 'http://example.com/images/sehoon_oh.jpg');


INSERT INTO `M_CREDITS` (`MOVIE_ID`, `ROLE`, `PERSON_NAME`, `POSITION`)
VALUES
    (1, 'Director', 'Jane Doe', 1),
    (1, 'Producer', 'John Smith', 2),
    (1, 'Screenwriter', 'Alice Johnson', 3),
    (2, 'Director', 'Robert Brown', 1),
    (2, 'Cinematographer', 'Emily Davis', 2);

INSERT INTO `M_DISCUSSIONS` (`MOVIE_ID`, `DISCUSSION_TEXT`)
VALUES
    (1, 'Great movie with an exciting plot. The adventure was thrilling from start to finish.'),
    (1, 'I loved the character development, especially the protagonist’s journey. The visuals were stunning.'),
    (2, 'An intriguing film with complex characters. The storyline was a bit slow but rewarding in the end.'),
    (2, 'The cinematography was top-notch. I enjoyed the film’s unique perspective on a classic genre.');


INSERT INTO `m_reviews` (`MOVIE_ID`, `REVIEW_TEXT`)
VALUES
    (1, 'An absolutely fantastic film! The storyline was captivating, and the performances were top-notch.'),
    (1, 'The movie had a strong start but lost momentum in the middle. The ending was satisfying, though.'),
    (1, 'Visually stunning with an engaging plot. The characters were well-developed and the direction was superb.'),
    (2, 'A thought-provoking film with an interesting narrative. The pacing was a bit slow, but it was worth watching.'),
    (2, 'I found the film to be a bit too long, but the acting and cinematography were excellent. A good watch overall.'),
    (2, 'The film was okay, but I expected more from the storyline. The visuals were impressive, but the plot was lacking.');


