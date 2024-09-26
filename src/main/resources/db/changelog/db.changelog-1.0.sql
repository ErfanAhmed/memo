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
CREATE TABLE company (
    id          INT NOT NULL,
    name        VARCHAR(100) NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE SEQUENCE company_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE company;
-- rollback DROP SEQUENCE company_seq;

-- changeset erfan:3
-- comment: create product
CREATE TABLE product (
    id                BIGINT       NOT NULL,
    name              VARCHAR(200) NOT NULL,
    quantity          DOUBLE PRECISION,
    description       VARCHAR(3000),
    unit_id           INT,
    company_id        INT,
    created           TIMESTAMP,
    updated           TIMESTAMP,
    version           INT,
    CONSTRAINT pk_product PRIMARY KEY (id),
    CONSTRAINT fk_p_unit_id FOREIGN KEY (unit_id) REFERENCES unit (id),
    CONSTRAINT fk_p_company_id FOREIGN KEY (company_id) REFERENCES company (id)
);

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE product;
-- rollback DROP SEQUENCE product_seq;

-- changeset erfan:4
-- comment: create quantity_per_unit
CREATE TABLE quantity_per_unit (
    id          BIGINT,
    amount      INT NOT NULL,
    unit_id     INT,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_quantity_per_unit PRIMARY KEY (id),
    CONSTRAINT fk_qpu_unit_id FOREIGN KEY (unit_id) REFERENCES unit(id)
);

-- changeset erfan:5
-- comment: create quantity_per_unit
CREATE TABLE unit_details (
    id          BIGINT,
    amount      INT NOT NULL,
    unit_id     INT,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_unit_details PRIMARY KEY (id),
    CONSTRAINT fk_ud_unit_id FOREIGN KEY (unit_id) REFERENCES unit(id)
);

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
