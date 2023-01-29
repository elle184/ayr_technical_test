-- 1. Database creation
create database db_phone_store;

-- 2. Administrator role creation
create role dps_admin inherit login password 'Do$00Ocho15Dos19Tre$';

-- 3. Administrator privileges creation
ALTER ROLE dps_admin CREATEROLE;

-- 4. Tables creation
create table brand(
    id serial primary key
    , name varchar(20) not null
    , creation_date timestamp not null default current_timestamp
    , update_date timestamp not null default current_timestamp
);

create table model(
    id serial primary key
    , brand_id int4 not null
    , name varchar(50) not null
    , creation_date timestamp not null default current_timestamp
    , update_date timestamp not null default current_timestamp
);

create table stock(
    id serial primary key
    , model_id int4
    , price money not null default 0.0
    , in_stock smallint not null default 100
    , rating smallint not null default 0
    , creation_date timestamp not null default current_timestamp
    , update_date timestamp not null default current_timestamp
);

alter table model
add constraint md_brand_fk
foreign key (brand_id)
references brand;

alter table stock
add constraint st_model_fk
foreign key (model_id)
references model;

-- 2. Role creation
create role client inherit login password '20230128';

-- 3. Add privileges to new role
grant select, update, insert, delete on all tables in schema public to client;
grant usage on brand_id_seq to client;