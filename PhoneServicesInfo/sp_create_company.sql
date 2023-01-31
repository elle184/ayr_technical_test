create or replace procedure sp_create_company(
    p_name varchar
    , p_address varchar
    , p_phone_number int8
) language plpgsql
as $$
begin

    insert into company (name, address, p_phone_number)
    values (p_name, p_address, p_phone_number);

    commit;
end; $$