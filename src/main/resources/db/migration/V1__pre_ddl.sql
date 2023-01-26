CREATE TABLE IF NOT EXISTS product (
    id       BIGINT      NOT NULL,
    name     VARCHAR(40) NOT NULL,
    quantity INT,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE SEQUENCE product_seq INCREMENT BY 1;

ALTER TABLE IF EXISTS product
    ADD COLUMN created TIMESTAMP,
    ADD COLUMN updated TIMESTAMP,
    ADD COLUMN version INT;
