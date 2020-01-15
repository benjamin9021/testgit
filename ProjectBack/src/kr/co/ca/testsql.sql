create table cuser(
did varchar2(6) primary key,
name varchar2(12) not null,
age number(2) default 19,
constraint chk_cuser_age_81_down check (age<81)
);

create table cinfo(
did varchar2(12) ,
cnum number(4) primary key,
cclr varchar2(12)
);
alter table cinfo add constraint id_fk foreign key (did) 
references cuser(did) ON DELETE CASCADE

insert into CUSER values('d02','kim',22);
insert into CUSER values('d03','lee',32);
insert into CUSER values('d04','oh',52);
insert into CUSER values('d05','ho',62);
insert into CUSER values('d07','hee',64);
insert into CUSER values('d08','huk',78);
insert into CUSER values('d09','kim',78);
insert into CUSER values('d10','ho',35);

insert into cinfo values('d02',7577,'blue');
insert into cinfo values('d09',8877,'blue');
insert into cinfo values('d03',8327,'blue');
insert into cinfo values('d04',8527,'blue');
insert into cinfo values('d07',7351,'red');
insert into cinfo values('d08',8727,'gray');
insert into cinfo values('d08',8888,'gray');
commit
select * from cuser natural join cinfo
select * from cinfo
select * from cuser
delete * from cuser natural join cinfo where did = 'd02'

delete from cinfo where cnum=7577

select c.did,c.name, u.cnum from cuser c, cinfo u where c.did = u.cid
select * from cuser where name = 'kim'


alter table cinfo add constraint id_fk foreign key (cid) references cuser(did)

drop table cinfo;
drop table cuser;


update cuser set name = 'hk', age = 33 where did = 'd02'
update cinfo set did = 'd58', cclr = 'gray' where cnum = 8877 
<--left outer join-->
select * from cuser left outer join cinfo on cuser.did = cinfo.did(+)
<--right outer join-->
select * from cinfo right outer join cuser on cinfo.did = cuser.did
<--full outer join-->
select * from cinfo full outer join cuser on cinfo.did = cuser.did
<--equi join-->
select name,age,number from c

on emp.deptno = dept.deptno
commit

testing
========================
insert into cuser values ('s001',
select * from cuser
select * from cinfo
delete from cuser where did = 'd02';
delete from cinfo where did = 'd02';