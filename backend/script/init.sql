CREATE DATABASE IF NOT EXISTS test_db;
USE test_db;

CREATE TABLE IF NOT EXISTS example_table (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO example_table (id, name) VALUES (1, 'kim');
INSERT INTO example_table (id, name) VALUES (2, 'lee');
INSERT INTO example_table (id, name) VALUES (3, 'park');
