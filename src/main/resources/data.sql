insert into users(id, email, password, username)
VALUES (1, 'ex1@gmail.com', 'qwerty', 'ex1'),
       (2, 'ex2@gmail.com', 'qwerty', 'ex2'),
       (3, 'ex3@gmail.com', 'qwerty', 'ex3'),
       (4, 'ex4@gmail.com', 'qwerty', 'ex4'),
       (5, 'ex5@gmail.com', 'qwerty', 'ex5');

insert into subscriptions(id, user_id, digital_service)
VALUES (1, 1, 'VK_MUSIC'),
       (2, 1, 'YANDEX_PLUS'),
       (3, 2, 'SPOTIFY'),
       (4, 2, 'NETFLIX'),
       (5, 2, 'AMAZON_PRIME'),
       (6, 3, 'SPOTIFY'),
       (7, 4, 'YANDEX_PLUS'),
       (8, 4, 'VK_MUSIC'),
       (9, 4, 'YOUTUBE_PREMIUM'),
       (10, 5, 'YANDEX_PLUS');
