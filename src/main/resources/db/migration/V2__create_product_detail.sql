CREATE TABLE IF NOT EXISTS product_detail (
    id       BIGINT      NOT NULL,
    description     VARCHAR(40) NOT NULL,
    product_id BIGINT NOT NULL ,
    CONSTRAINT pk_product_detail PRIMARY KEY (id),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(id)
);