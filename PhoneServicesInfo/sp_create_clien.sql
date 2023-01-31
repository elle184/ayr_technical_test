create or replace procedure sp_create_client(
    p_security_code varchar
    , p_full_name varchar
)
language plpgsql
as $$
begin
    insert into client (security_code, full_name)
    values (p_security_code, p_full_name);

    commit;
end; $$