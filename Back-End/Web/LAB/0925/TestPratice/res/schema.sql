drop database if exists ssafy_test;
create database ssafy_test;
use ssafy_test;

create table tmember(
	mid varchar(45) primary key,	# 사용자 아이디
    mpass varchar(45) not null,		# 사용자 비밀번호
    mname varchar(45) not null		# 사용자 이름
);

insert into tmember (mid, mpass, mname) values('ssafy','1234','싸피인');

create table tproduct(
	pcode varchar(45) primary key,	# 제품 코드
    pname varchar(45) not null,		# 제품 이름
    pquantity int not null			# 제품 수량
);

insert into tproduct (pcode, pname, pquantity) values('book1', '자바책', 10), ('book2','DB책', 4);
commit;
select * from tproduct;