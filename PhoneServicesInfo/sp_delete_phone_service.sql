create or replace procedure sp_delete_phone_service(
    p_client_id int4
    , p_phone_number int4
) language plpgsql as $$
begin 

    delete from phone_service
    where client_id = p_client_id
    and phone_number = p_phone_number;

    commit;

end; $$