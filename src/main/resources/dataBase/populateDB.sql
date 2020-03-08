DELETE FROM user_roles;
DELETE FROM book_user;
DELETE FROM books;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email) VALUES
  ( 'User', 'user@google.ua'),
  ( 'Admin', 'admin@google.ua');

INSERT INTO user_roles (user_id, role) VALUES
  (1000, 'ROLE_USER' ),
  (1001, 'ROLE_ADMIN' ),
  (1001, 'ROLE_USER');


INSERT INTO books ( name, author, date, price)
VALUES ('Монах, що продав свій феррарі', 'Робін Шарма', '2015', 100),
       ('Найбагатша людина у Вавилоні', 'Джордж Клейсон', '2017', 120),
       ('Стратегії геніїв', 'Девід Йоффе, Майкл Кузумано', '2017', 110);

INSERT INTO book_user (user_id, book_id) VALUES
(1000, 1002),
-- (1000, 1003),
-- (1000, 1004),
-- (1001, 1002),
-- (1001, 1003),
(1001, 1004);