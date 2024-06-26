

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
						
insert into visit values(seq_visit_idx.nextVal,
						'김철수',
						'我叫金哲洙,住在首尔,今年三十多岁。我在市场营销部门工作。平时喜欢锻炼身体、阅读和旅行。周末会和家人在一起放松。我的梦想是有朝一日开设自己的小咖啡厅,与人们交流,度过美好的时光。我会继续努力,实现这个梦想。谢谢。',
						'gdsSAFJ13omdg',
						'192.168.219.119',
						sysdate
						);
						
-- JDBC용 insert문

select * from visit

insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate);

-- view로 생성

create or replace view visit_view
as
select rownum as no, v.*
from (select * from visit order by idx desc) v;

select * from visit_view where idx = 21;

-- 수정

update visit set name = '일길동',
				 content = '내가 일등이다',
				 pwd = '1234',
				 ip = '192.168.0.107',
				 regdate = sysdate
where idx = 26;

						
-- idx 내림차순 (최신글 맨 꼭대기에 올리겠다)

select * from visit order by idx desc;

commit