create or replace procedure sp_manage_company_plan(
	p_action varchar
	, p_id int4
	, p_company_id int4
	, p_name varchar
	, p_price int4
) language plpgsql as $$
begin 
	if p_action is not null then 
		if p_action = 'CREATE' then
			insert into plan (company_id, name, price)
			values (p_company_id, p_name, p_price);
		
			commit;
		elsif p_action = 'UPDATE' and p_id is not null then
			update plan
			set name = p_name
			, price = p_price
			, modification_date = current_timestamp
			where id = p_id;
		
			commit;
		elsif p_action = 'DELETE' and p_id is not null then
			delete from plan where id = p_id;
		
			if (select count(*) from phone_service where plan_id = p_id) > 0 then
				delete from phone_service where plan_id = p_id;
			end if;
		
			commit;
		end if;
	end if;
end; $$
