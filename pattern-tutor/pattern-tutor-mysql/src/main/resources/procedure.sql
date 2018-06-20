drop procedure if exists looppc;
create procedure looppc()
begin
declare i int;
set i = 1;

repeat
	select * from system_dictionary;
	set i = i + 1;
	until i >= 1000000000
end repeat;

end

call looppc()

-- view processlist
show processlist