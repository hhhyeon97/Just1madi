

-- 1/1 

select * from MemoUser order by createdate desc;
delete from MemoUser;
select * from Memo;
delete from Memo;
drop table MemoUser;
commit;

