DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;

CREATE TABLE users
(
    id BIGINT PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE
);


CREATE INDEX idx_users_email
    ON users (email);