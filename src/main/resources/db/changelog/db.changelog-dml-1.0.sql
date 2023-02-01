-- liquibase formatted sql

-- changeset erfan:1
-- comment: insert into unit
INSERT INTO unit (id, name, created, updated, version)
values
    (1, 'KG', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Liter', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Pcs', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);


-- changeset erfan:2
-- comment: insert into brand
INSERT INTO brand (id, name, created, updated, version)
values
    (1, 'Pran', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Radhuni', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Bashundhora', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

-- changeset erfan:3
-- comment: insert into product
INSERT INTO product (id, name, description, brand_id, quantity, created, updated, version)
values
    (1, 'Ata 2kg', '', 1, 20 , '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Morich gura 400gm', '', 2, 30 , '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Toilet Tissue', '', 3, 10 , '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);
