-- liquibase formatted sql

-- changeset erfan:1
CREATE TABLE IF NOT EXISTS product (
    id          BIGINT NOT NULL,
    name        VARCHAR(40) NOT NULL,
    quantity    INT,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    VERSION     INT,
    CONSTRAINT pk_product PRIMARY KEY (id)
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

   From 4.19.0 it works,
   rollback empty
 */
