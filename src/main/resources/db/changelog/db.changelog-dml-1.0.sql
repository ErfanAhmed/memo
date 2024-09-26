-- liquibase formatted sql

-- changeset erfan:1
-- comment: insert into unit
INSERT INTO unit (id, name, created, updated, version)
values
    (1, 'K.G.', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Gm.', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Liter', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (4, 'Pcs', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (5, 'Box', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (6, 'Packet', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('unit_seq', 6, TRUE);

-- changeset erfan:2
-- comment: insert into company
INSERT INTO company (id, name, created, updated, version)
values
    (1, 'Pran', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Radhuni', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Bashundhora', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('company_seq', 3, TRUE);

-- changeset erfan:3
-- comment: insert into product
INSERT INTO product (id, name, quantity, unit_id, company_id, created, updated, version)
values
    (1, 'Ata', 10, 6, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Morich gura', 10, 6, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Toilet Tissue', 20, 5, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('product_seq', 3, TRUE);

-- changeset erfan:4
-- comment: insert into quantity_per_unit
INSERT INTO quantity_per_unit (id, amount, unit_id, created, updated, version)
values
    (1, 500, 2, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 250, 2, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

-- changeset erfan:5
-- comment: insert into unit_details
INSERT INTO unit_details (id, amount, unit_id, created, updated, version)
values
    (3, 30, 4, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);
