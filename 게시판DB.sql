

-- 일련번호 관리하는 객체

create sequence seq_visit_idx_practice

-- 게시판 테이블

create table visit_practice
(
	idx int, 							-- 일련번호
	name varchar2(100) not null,		-- 작성자
	title varchar2(100) not null,		-- 제목
	content varchar2(2000) not null, 	-- 내용
	pwd varchar2(100) not null,			-- 비밀번호
	ip varchar2(100) not null, 			-- 아이피
	regdate date						-- 작성일자
)

-- 기본키

alter table visit_practice
	add constraint pk_visit_practice_idx primary key(idx);
	
-- sample data

insert into visit_practice values(seq_visit_idx_practice.nextVal,
								'일길동',
								'게시판 처음으로 열렸네요 안녕하세요',
								'게시판 처음으로 열려서 글을 남깁니다.',
								'1234',
								'192.168.219.170',
								sysdate
								);
								
insert into visit_practice values(seq_visit_idx_practice.nextVal,
								'일길동',
								'게시판 처음으로 열렸네요 안녕하세요',
								'게시판 처음으로 열려서 글을 남깁니다.',
								'1234',
								'192.168.219.170',
								sysdate
								);

-- idx 내림차순 (최신글 맨 꼭대기에 올리겠다)

select * from visit_practice order by idx desc;

commit
