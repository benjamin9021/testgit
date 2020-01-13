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
alter table cinfo add constraint id_fk foreign key (did) references cuser(did);


insert into CUSER values('d02','kim',22);
insert into CUSER values('d03','lee',32);
insert into CUSER values('d04','oh',52);
insert into CUSER values('d05','ho',62);
insert into CUSER values('d07','hee',64);
insert into CUSER values('d08','huk',78);
insert into CUSER values('d09','kim',78);

insert into cinfo values('d02',7577,'blue');
insert into cinfo values('d09',8877,'blue');
insert into cinfo values('d03',8327,'blue');
insert into cinfo values('d04',8527,'blue');
insert into cinfo values('d07',7351,'red');
insert into cinfo values('d08',8727,'gray');
insert into cinfo values('d08',8888,'gray');
commit
select * from cuser natural join cinfo
delete * from cuser natural join cinfo where did = 'd02'

select c.did,c.name, u.cnum from cuser c, cinfo u where c.did = u.cid
select * from cuser where name = 'kim'


alter table cinfo add constraint id_fk foreign key (cid) references cuser(did)

drop table cinfo;
drop table cuser;




commit
insert into cuser values ('s001',
select * from cuser
select * from cinfo
delete from cuser where did = 'd02';
delete from cinfo where did = 'd02';
test


