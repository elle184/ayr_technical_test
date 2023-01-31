create or replace procedure sp_create_phone_service(
    p_client_id bigint
    , p_plan_id bigint
    , p_phone_number int8
) language plpgsql as $$
declare 
    clientId int4;
    planId int4;
begin 

    select id into clientId from client where id = p_client_id;
    select id into planId from plan where id = p_plan_id;

    if (clientId is not null and clientId <> 0)
    and (planId is not null and planId <> 0) then
        insert into phone_service(client_id, plan_id, phone_number)
        values (clientId, planId, p_phone_number);
    end if;

    commit;

end; $$