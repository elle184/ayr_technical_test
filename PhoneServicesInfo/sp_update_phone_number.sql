create or replace procedure sp_update_phone_service(
    p_client_id int4
    , p_plan_id int4
    , p_phone_number int4
) language plpgsql as $$
begin 

    update phone_service
    set plan_id = p_plan_id
    , modification_date = current_timestamp
    where client_id = p_client_id
    and phone_number = p_phone_number;

    commit;

end; $$