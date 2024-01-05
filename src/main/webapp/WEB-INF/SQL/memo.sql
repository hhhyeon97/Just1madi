

-- 1/1 

select * from MemoUser order by createdate desc;
delete from MemoUser;
select * from Memo order by memoId desc;
delete from Memo;
drop table Memo;
commit;


-- 1/2 admin 롤 
update MemoUser set role ='ROLE_ADMIN' where username='admin';
commit;

