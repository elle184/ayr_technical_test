create table client(
    id serial primary key
    , security_code varchar(256) not null
    , full_name varchar(200) not null
    , creation_date timestamp not null default current_timestamp
    , modification_date timestamp not null default current_timestamp
);

create table company(
    id serial primary key
    , name varchar(50) not null
    , address varchar(150) not null
    , phone_number int4 not null
    , creation_date timestamp not null default current_timestamp
    , modification_date timestamp not null default current_timestamp
);

create table plan(
    id serial primary key
    , company_id int4 not null
    , name varchar(100) not null
    , price money not null
    , creation_date timestamp not null default current_timestamp
    , modification_date timestamp not null default current_timestamp
);

create table phone_service(
    id serial primary key
    , client_id int4 not null
    , plan_id int4 not null
    , phone_number smallint not null
    , creation_date timestamp not null default current_timestamp
    , modification_date timestamp not null default current_timestamp
);

alter table plan
add constraint p_company_fk
foreign key (company_id)
references company;

alter table phone_service
add constraint ps_client_fk
foreign key (client_id)
references client;

alter table phone_service
add constraint ps_plan_fk
foreign key (plan_id)
references plan;