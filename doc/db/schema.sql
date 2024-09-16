CREATE TABLE `M_MOVIES` (
                            `MOVIE_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '영화_시퀀스',
                            `TITLE` VARCHAR(255) NOT NULL COMMENT '영화_제목',
                            `ORIGINAL_TITLE` VARCHAR(255) COMMENT '원제',
                            `STATUS` VARCHAR(50) COMMENT '상태',
                            `ORIGINAL_LANGUAGE` VARCHAR(50) COMMENT '원어',
                            `BUDGET` DECIMAL(15, 2) COMMENT '제작비',
                            `REVENUE` DECIMAL(15, 2) COMMENT '수익',
                            `KEYWORDS` TEXT COMMENT '키워드',
                            `RELEASE_DATE` DATETIME NOT NULL COMMENT '개봉일',
                            `AGE_RATING` VARCHAR(50) NOT NULL COMMENT '관람등급',
                            `GENRE` VARCHAR(50) NOT NULL COMMENT '장르',
                            `RUNTIME` INT NOT NULL COMMENT '상영시간',
                            `RATING` DECIMAL(3, 2) NOT NULL COMMENT '평점',
                            `OVERVIEW` TEXT COMMENT '개요',
                            `SUB_DESCRIPTION` TEXT COMMENT '부가설명',
                            `STORY` TEXT COMMENT '스토리',
                            `DIRECTOR` VARCHAR(255) COMMENT '감독',
                            `IMAGE_URL` VARCHAR(255) COMMENT '이미지_URL',
                            PRIMARY KEY (`MOVIE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화';



CREATE TABLE `M_CREDITS` (
                             `CREDIT_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '크레딧_시퀀스',
                             `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                             `ROLE` VARCHAR(50) NOT NULL COMMENT '역할_타입',
                             `PERSON_NAME` VARCHAR(255) NOT NULL COMMENT '인물_이름',
                             `POSITION` INT(10) NOT NULL COMMENT '역할_순서',
                             PRIMARY KEY (`CREDIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_크레딧';


CREATE TABLE `M_CAST` (
                          `CAST_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '출연진_시퀀스',
                          `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                          `ACTOR_NAME_KR` VARCHAR(255) NOT NULL COMMENT '배우_이름_한글',
                          `ACTOR_NAME_EN` VARCHAR(255) NOT NULL COMMENT '배우_이름_영문',
                          `IMAGE_URL` VARCHAR(255) COMMENT '배우_이미지_URL',
                          PRIMARY KEY (`CAST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_출연진';


CREATE TABLE `M_REVIEWS` (
                             `REVIEW_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '리뷰_시퀀스',
                             `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                             `REVIEW_TEXT` TEXT NOT NULL COMMENT '리뷰_내용',
                             PRIMARY KEY (`REVIEW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_리뷰';


CREATE TABLE `M_DISCUSSIONS` (
                                 `DISCUSSION_ID` INT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '토론_시퀀스',
                                 `MOVIE_ID` INT(10) unsigned NOT NULL COMMENT '영화_시퀀스',
                                 `DISCUSSION_TEXT` TEXT NOT NULL COMMENT '토론_내용',
                                 PRIMARY KEY (`DISCUSSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='영화_토론';






-- -----


-- M_MOVIES 테이블에 대한 샘플 데이터
-- 샘플 데이터 추가 (영화)
INSERT INTO `M_MOVIES` (`TITLE`, `ORIGINAL_TITLE`, `STATUS`, `ORIGINAL_LANGUAGE`, `BUDGET`, `REVENUE`, `KEYWORDS`, `RELEASE_DATE`, `AGE_RATING`, `GENRE`, `RUNTIME`, `RATING`, `OVERVIEW`, `SUB_DESCRIPTION`, `STORY`, `DIRECTOR`, `IMAGE_URL`)
VALUES
    ('The Grand Adventure', 'The Grand Adventure', 'Released', 'English', 50000000.00, 150000000.00, 'adventure, hero, epic', '2024-01-15', 'PG-13', 'Action', 120, 8.50, 'An epic journey of a young hero.', 'A thrilling adventure across lands.', 'A young hero embarks on an epic journey to save his world from darkness.', 'Jane Doe', 'http://example.com/images/grand_adventure.jpg'),
    ( 'The Mystery Manor', 'The Mystery of the Manor', 'Released', 'English', 30000000.00, 90000000.00, 'mystery, haunted house, detective', '2023-10-31', 'PG', 'Mystery', 95, 7.80, 'A detective unravels the dark secrets of a haunted mansion.', 'A spooky mystery-solving adventure.', 'A detective discovers the truth behind a haunted manor.', 'John Smith', 'http://example.com/images/mystery_manor.jpg'),
    ( 'Beetlejuice', 'Beetlejuice', 'Released', 'English', 15000000.00, 74000000.00, 'ghosts, afterlife, comedy', '1988-03-30', 'PG', 'Comedy', 92, 7.50, 'A deceased couple tries to scare away new inhabitants of their home with the help of Beetlejuice.', 'A comedic journey through the afterlife.', 'Beetlejuice helps a ghost couple haunt their old house.', 'Tim Burton', 'http://example.com/images/beetlejuice.jpg'),
    ( 'Space Voyage', 'Voyage to the Stars', 'In Production', 'English', 100000000.00, 0.00, 'space, exploration, sci-fi', '2025-07-22', 'PG-13', 'Sci-Fi', 150, 9.10, 'A crew of astronauts embark on a perilous journey to explore a distant galaxy.', 'A sci-fi space adventure like no other.', 'A crew faces the unknown as they travel to uncharted galaxies.', 'Sarah Connor', 'http://example.com/images/space_voyage.jpg'),
    ( 'The Heart of the Forest', 'El Corazón del Bosque', 'Released', 'Spanish', 25000000.00, 85000000.00, 'fantasy, magic, forest', '2023-08-11', 'PG', 'Fantasy', 105, 8.20, 'A young woman discovers a magical forest that holds the secret to her family\'s past.', 'A magical and heartwarming journey through the forest.', 'A mystical adventure about family and destiny.', 'Maria Gonzales', 'http://example.com/images/heart_of_forest.jpg');


-- M_CAST 테이블에 대한 샘플 데이터
INSERT INTO M_CAST (MOVIE_ID, ACTOR_NAME_KR, ACTOR_NAME_EN, IMAGE_URL)
VALUES
(1, '김철수', 'Chul-Soo Kim', 'http://example.com/images/chulsoo_kim.jpg'),
(1, '박영희', 'Young-Hee Park', 'http://example.com/images/younghee_park.jpg'),
(2, '톰 하디', 'Tom Hardy', 'http://example.com/images/tom_hardy.jpg'),
(2, '마고 로비', 'Margot Robbie', 'http://example.com/images/margot_robbie.jpg'),
(3, '마이클 키튼', 'Michael Keaton', 'http://example.com/images/michael_keaton.jpg'),
(3, '지나 데이비스', 'Geena Davis', 'http://example.com/images/geena_davis.jpg'),
(4, '크리스 프랫', 'Chris Pratt', 'http://example.com/images/chris_pratt.jpg'),
(4, '조 샐다나', 'Zoe Saldana', 'http://example.com/images/zoe_saldana.jpg'),
(5, '에밀리 블런트', 'Emily Blunt', 'http://example.com/images/emily_blunt.jpg'),
(5, '존 크래신스키', 'John Krasinski', 'http://example.com/images/john_krasinski.jpg');

-- M_CREDITS 테이블에 대한 샘플 데이터
INSERT INTO M_CREDITS (MOVIE_ID, ROLE, PERSON_NAME, POSITION)
VALUES
(1, 'Director', 'Jane Doe', 1),
(1, 'Writer', 'Eric Johnson', 2),
(2, 'Director', 'John Smith', 1),
(2, 'Writer', 'Sally Davis', 2),
(3, 'Director', 'Tim Burton', 1),
(3, 'Writer', 'Michael McDowell', 2),
(3, 'Producer', 'Larry Wilson', 3),
(3, 'Composer', 'Danny Elfman', 4),
(4, 'Director', 'Samantha Johnson', 1),
(4, 'Producer', 'David Brown', 2),
(4, 'Visual Effects', 'Rachel Green', 3),
(5, 'Director', 'Lucas Miller', 1),
(5, 'Cinematographer', 'Thomas Green', 2),
(5, 'Editor', 'Lily Adams', 3);

-- M_REVIEWS 테이블에 대한 샘플 데이터
INSERT INTO M_REVIEWS (MOVIE_ID, REVIEW_TEXT)
VALUES
    (1, 'A stunning adventure that keeps you on the edge of your seat!'),
    (1, 'The landscapes are beautiful and the story is gripping.'),
    (2, 'A heartwarming tale with great performances by both leads.'),
    (2, 'The chemistry between Tom Hardy and Margot Robbie is electric.'),
    (3, 'A hilarious and darkly quirky film that stands the test of time.'),
    (3, 'Michael Keaton is absolutely unforgettable as Beetlejuice.'),
    (4, 'Visually stunning with excellent space adventure storytelling.'),
    (4, 'The pacing was a bit slow, but the visuals and world-building are top-notch.'),
    (5, 'An intense horror film that left me on the edge of my seat.'),
    (5, 'The Dark Forest was creepy, but I felt the characters made too many dumb choices.');

-- M_DISCUSSIONS 테이블에 대한 샘플 데이터
INSERT INTO M_DISCUSSIONS (MOVIE_ID, DISCUSSION_TEXT)
VALUES
(1, 'Who else loved the final battle scene?'),
(1, 'The plot twist at the end was so unexpected!'),
(2, 'What do you think about the ending? Should they have stayed together?'),
(2, 'The soundtrack for this movie is absolutely beautiful.'),
(3, 'Do you think Beetlejuice should have had more screen time? He was hilarious!'),
(3, 'What was your favorite scene in Beetlejuice? Mine was when they summoned him for the first time.'),
(4, 'The Space Voyage felt like a spiritual successor to classic space operas. Thoughts?'),
(4, 'Did anyone catch the hidden Easter egg in the background during the final scene?'),
(5, 'I was on the edge of my seat the whole time! What an intense experience!'),
(5, 'Did anyone else notice the eerie similarity between this film and some classic 80s horror films?');