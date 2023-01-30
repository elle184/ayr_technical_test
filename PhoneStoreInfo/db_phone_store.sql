-- Assign privileges with dps_admin
grant usage on brand_id_seq to client;
grant usage on model_id_seq to client;
grant usage on stock_id_seq to client;

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