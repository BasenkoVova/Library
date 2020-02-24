DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1000;

CREATE TABLE users
(
    id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name  VARCHAR NOT NULL,
    email VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);


CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE books
(
    id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name   VARCHAR NOT NULL,
    date   VARCHAR NOT NULL,
    author VARCHAR NOT NULL,
    price  INTEGER NOT NULL
--   FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
-- CREATE UNIQUE INDEX books_unique_user_date_idx
--   ON books (date);


CREATE TABLE book_user
(
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE
);