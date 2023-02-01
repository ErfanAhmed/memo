-- liquibase formatted sql

-- changeset erfan:1
-- comment: create unit
CREATE TABLE unit (
    id          INT NOT NULL,
    name        VARCHAR NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_quantity PRIMARY KEY (id)
);

CREATE SEQUENCE unit_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE unit;
-- rollback DROP SEQUENCE unit_seq;

-- changeset erfan:2
-- comment: create brand
CREATE TABLE brand (
    id          INT NOT NULL,
    name        VARCHAR(100) NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_brand PRIMARY KEY (id)
);

CREATE SEQUENCE brand_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE brand;
-- rollback DROP SEQUENCE brand_seq;

-- changeset erfan:3
-- comment: create product
CREATE TABLE product (
    id          BIGINT NOT NULL,
    name        VARCHAR(200) NOT NULL,
    description VARCHAR(3000),
    quantity    DOUBLE PRECISION,
    brand_id    INT,
    unit_id     INT,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_product PRIMARY KEY (id),
    CONSTRAINT fk_brand_id FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT fk_unit_id FOREIGN KEY (unit_id) REFERENCES unit(id)
);

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE product;
-- rollback DROP SEQUENCE product_seq;

/* doesn't work upto liquibase core v 4.18.0]
    rollback none
    rollback empty

   the following doesn't cause error but deletes corresponding entry from the
   databasechangelog table that in turns causes error while running update
   command afterwards.

   rollback SELECT 'N/A';

   From 4.19.0 `rollback empty` gives no error,
   the command executes but also deletes corresponding row from databasechangelog table
 */
