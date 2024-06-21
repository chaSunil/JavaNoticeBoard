

-- 일련번호 관리하는 객체

create sequence seq_visit_idx

-- 방명록 테이블

create table visit
(
	idx     int,		               -- 일련번호
	name    varchar2(100)  not null,   -- 작성자
	content varchar2(2000) not null,   -- 내용
	pwd     varchar2(100)  not null,   -- 비밀번호
	ip      varchar2(100)  not null,   -- 아이피
	regdate date                       -- 작성일자
)

-- 기본키

alter table visit
	add constraint pk_visit_idx primary key(idx);
	
-- sample data

insert into visit values(seq_visit_idx.nextVal,
						'일길동',
						'내가 1등이네',
						'1234',
						'192.168.219.170',
						sysdate
						);

insert into visit values(seq_visit_idx.nextVal,
						'이길동',
						'뭐여 언제 1등가져감',
						'1234',
						'192.168.219.170',
						sysdate
						);
						
insert into visit values(seq_visit_idx.nextVal,
						'삼길동',
						'크크루삥뽕',
						'1234',
						'192.168.219.170',
						sysdate
						);
						
-- JDBC용 insert문

insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate);

-- view로 생성

create or replace view visit_view
as
select rownum as no, v.*
from (select * from visit order by idx desc) v;

select * from visit_view where idx = 21;

						
-- idx 내림차순 (최신글 맨 꼭대기에 올리겠다)

select * from visit order by idx desc;