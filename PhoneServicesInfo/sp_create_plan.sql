create or replace procedure sp_create_plan(
    p_company_id int4
    , p_name varchar
    , p_price money
) language plpgsql
as $$
begin

    insert into plan(company_id, name, price)
    values (p_company_id, p_name, p_price);

    commit;
end; $$