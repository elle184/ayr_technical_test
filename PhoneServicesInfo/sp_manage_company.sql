create or replace procedure sp_manage_company(
    p_id int4
    , p_action varchar
    , p_name varchar
    , p_address varchar
    , p_phone_number int8
) language plpgsql as $$
begin 

    if p_action IS NOT NULL THEN
        IF p_action = 'CREATE' THEN
            insert into company(name, address, phone_number)
            values (p_name, p_address, p_phone_number);
           
           commit;
        ELSIF p_action = 'UPDATE' and p_id is not null THEN
            update company set
            name = p_name
            , address = p_address
            , phone_number = p_phone_number
            , modification_date = current_timestamp
            where id = p_id;
           
           commit;
        end if;
    END if;

end; $$