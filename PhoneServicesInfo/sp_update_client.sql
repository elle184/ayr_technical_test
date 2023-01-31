create or replace procedure sp_update_client(
	p_security_code varchar
	, p_full_name varchar
) language plpgsql as $$
begin
	update client set	
	full_name = p_full_name
	, modification_date = current_timestamp
	where security_code = p_security_code;
end; $$