DELETE FROM DISHES;
DELETE FROM RESTAURANTS;
DELETE FROM USER_ROLES;
DELETE FROM USERS;
DELETE FROM VOTES;

INSERT INTO restaurants VALUES
  (NULL , 'restaurant1'),
  (NULL , 'restaurant2'),
  (NULL , 'restaurant3');


INSERT INTO dishes VALUES
  (NULL ,'dish_r1_1', 21.30, NOW(),0),
  (NULL ,'dish_r2_1', 21.30, NOW(),1),
  (NULL ,'dish_r2_2', 21.30, NOW(),1),
  (NULL ,'dish_r3_1', 21.30, NOW(),2),
  (NULL ,'dish_r1_2', 21.30, NOW(),0);

INSERT INTO users
VALUES (NULL ,'User', 'user@yandex.ru', '$2a$10$9K/ajS.I2mGnEgxYKm23XO9OLiWZXCCFD0zuNjCgMdxuO07GexnDq', now(), TRUE);

INSERT INTO users
VALUES (NULL ,'Admin', 'admin@gmail.com', '$2a$10$nEb1AlaocL4yE3Nt8fgOkOVwtQB7RGx756X.26O.3j9/rfXVqmpoi', now(), TRUE);

INSERT INTO user_roles VALUES
  (0, 'ROLE_USER'),
  (1, 'ROLE_ADMIN');

INSERT INTO votes
VALUES (NULL ,1,0,now());
