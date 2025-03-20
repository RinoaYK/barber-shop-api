-- V20250320105015__create_table_clients.sql generated in G:\Dio\decola-tech-2025\Projetos\Barber Shop\barber-shop-api\src\main\resources\db\migration
CREATE TABLE CLIENTS (
                         id BIGSERIAL not null primary key,
                         name VARCHAR(150) not null,
                         email VARCHAR(150) not null,
                         phone BPCHAR(11) not null,
                         CONSTRAINT UK_EMAIL  UNIQUE (email),
                         CONSTRAINT UK_PHONE  UNIQUE (phone)
);