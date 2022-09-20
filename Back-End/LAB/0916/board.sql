create database ssafy_8th;

use ssafy_8th;

create table book_tb (
	bno int primary key auto_increment,
    title varchar(50) not null,
    writer varchar(50) not null,
    publisher varchar(50) not null,
    price int
);

create table board_tb (
	bno int primary key auto_increment,
    title varchar(50) not null,
    writer varchar(50) not null,
    content text,
	write_date datetime, 
    read_count int default 0
);

insert into board_tb(title, writer, content, write_date)
values('첫번째 글','현인', '첫 번째 글입니다', now());

insert into board_tb(title, writer, content, write_date)
values('N번째 글','현인', 'N 번째 글입니다', now());

select bno, title, writer, content, write_date, read_count from board_tb where bno=1;

select * from board_tb;

update board_tb set read_count = read_count+1
where bno = 1;

delete from board_tb where bno=1;

select bno, title, writer, write_date, read_count
from board_tb order by bno desc limit 1, 3; -- limit 의 시작지점은 0번 인덱스