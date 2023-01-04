BEGIN;

DROP TABLE IF EXISTS employees_details CASCADE;
CREATE TABLE employees_details (id bigserial PRIMARY KEY, email VARCHAR(255), city varchar(255));
INSERT INTO employees_details (email, city) VALUES
('terminator@gmail.com', 'California'),
('rembo@gmail.com', 'Atlanta'),
('corben_dallas@gmail.com', 'New York');

DROP TABLE IF EXISTS employees CASCADE;
CREATE TABLE employees (id bigserial PRIMARY KEY, name VARCHAR(255), details_id bigint, FOREIGN KEY (details_id) REFERENCES employees_details (id));
INSERT INTO employees (name, details_id) VALUES
('Arnold S.', 1),
('Silvester S.', 2),
('Willis B.', 3);

DROP TABLE IF EXISTS simple_items CASCADE;
CREATE TABLE simple_items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO simple_items (title, price) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door', 50),
('camera', 500);

DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO books (title) VALUES
('Mistborn'),
('Neverwhere'),
('Ambers Chronicles'),
('Harry Potter'),
('Lockwood & Co.'),
('Foundation Trilogy'),
('Liveship Traders Trilogy'),
('A Night in the Lonesome October'),
('Da Vinci Code'),
('Lord of the Ring');

DROP TABLE IF EXISTS readers CASCADE;
CREATE TABLE readers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO readers (name) VALUES
('Alexander'),
('Bob');

DROP TABLE IF EXISTS books_readers CASCADE;
CREATE TABLE books_readers (book_id bigint, reader_id bigint, FOREIGN KEY (book_id) REFERENCES books (id), FOREIGN KEY (reader_id) REFERENCES readers (id));
INSERT INTO books_readers (book_id, reader_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(1, 2);

DROP TABLE IF EXISTS universities CASCADE;
CREATE TABLE universities (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO universities (title) VALUES
('DSTU'),
('NPU');

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), university_id bigint REFERENCES universities (id));
INSERT INTO students (name, university_id) VALUES
('Alexander', 1),
('Bob', 2),
('John', 1);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);

COMMIT;