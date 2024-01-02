

-- 1/1 

select * from MemoUser order by createdate desc;
delete from MemoUser;
select * from Memo;
delete from Memo;
drop table MemoUser;
commit;


-- 1/2 admin 롤 
update MemoUser set role ='ROLE_ADMIN' where username='admin';
commit;

