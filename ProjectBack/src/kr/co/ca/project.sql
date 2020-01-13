create table cuser(

	did varchar2(6) primary key,
	name varchar2(12) not null,
	age number(2) default 19,
	constraint cheeck_cuser_age_81_down check(age < 81)

)

create table cinfo(

	cid varchar2(6)primary key, 
	cc varchar2(12) not null,
	cn number(4),
	constraint fk_cinfo_cid_cuser_did foreign key(cid) references cuser(did)
)


insert into cuser values ('p001', 'kim', 20);
insert into cuser values ('p002', 'lee', 30);
insert into cuser values ('p003', 'pack', 40);
insert into cuser values ('p004', 'beck', 50);
insert into cuser values ('p005', 'lim', 60);
insert into cuser values ('p006', 'song', 70);
insert into cuser values ('p007', 'yoo', 80);
commit


insert into cinfo values ('p001', 'rd' , 5537);
insert into cinfo values ('p002', 'bl' , 1124);
insert into cinfo values ('p003', 'gr' , 5588);
insert into cinfo values ('p004', 'yw' , 1234);
insert into cinfo values ('p005', 'wt' , 5556);
insert into cinfo values ('p006', 'bk' , 6654);
insert into cinfo values ('p007', 'pk' , 6565);
commit

alter table cinfo drop column 'p001'


drop table cuser
drop table cinfo


select * from cuser sc, cinfo ci where m.did = ci.did


select * from memeber m, depart d where m.did = d.did

select m.id, m.name, m.age from memeber m, depart d where m.did = d.did




-----------------------------------------------------------------------------



create table cuser(
did varchar2(6) primary key,
name varchar2(12) not null,
age number(2) default 19,
constraint chk_cuser_age_81_down check (age<81)
)


create table cinfo(
did varchar2(12) ,
cnum number(4) primary key,
cclr varchar2(12)
)

alter table cinfo add constraint id_fk foreign key (did) references cuser(did)


insert into CUSER values('d02','kim',22);
insert into CUSER values('d03','lee',32);
insert into CUSER values('d04','oh',52);
insert into CUSER values('d05','ho',62);
insert into CUSER values('d07','hee',64);
insert into CUSER values('d08','huk',78);

insert into cinfo values('d02',7577,'blue');
insert into cinfo values('d03',8327,'blue');
insert into cinfo values('d04',8527,'blue');
insert into cinfo values('d07',7351,'red');
insert into cinfo values('d08',8727,'gray');
commit

select * from cuser natural join cinfo
select * from cuser natural join cinfo
drop table cuser
drop table cinfo