DROP TABLE IF EXISTS properties CASCADE;
DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;

CREATE TABLE properties
(
    id BIGINT PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
    property_code VARCHAR(10) NOT NULL UNIQUE,
    leased BOOLEAN NOT NULL,
    address VARCHAR(255) NOT NULL UNIQUE,
    number_of_apartments BIGINT NOT NULL
);


CREATE INDEX idx_properties_code
    ON properties (property_code);

