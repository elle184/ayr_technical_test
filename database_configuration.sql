-- Database creation
-- This creations are with postgres user.
create database db_phone_services;
create database db_phone_store;

-- Administrator role creation
create role dps_admin inherit login password 'Do$00Ocho15Dos19Tre$';

-- Administrator privileges creation
ALTER ROLE dps_admin CREATEROLE;

-- Role creation
create role client inherit login password '20230128';

-- Add privileges to new role
grant select, update, insert, delete on all tables in schema public to client;