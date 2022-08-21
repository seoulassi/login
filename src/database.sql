--------------------------------------------------------
--  DDL for Table SE_MEMBER
--  ORACLE
--------------------------------------------------------

  CREATE TABLE "SE_MEMBER"
   (	"USER_NAME" VARCHAR2(50),
	"PASSWORD" VARCHAR2(100),
	"NAME" VARCHAR2(50),
	"USER_CNO" NUMBER,
	"USER_ID" VARCHAR2(20),
	"CREATE_DATE" DATE,
	"DEL_FLAG" CHAR(1) DEFAULT 1
   )

   COMMENT ON COLUMN "SE_MEMBER"."USER_NAME" IS '유저네임'
   COMMENT ON COLUMN "SE_MEMBER"."PASSWORD" IS '비밀번호'
   COMMENT ON COLUMN "SE_MEMBER"."NAME" IS '이름'
   COMMENT ON COLUMN "SE_MEMBER"."USER_CNO" IS '넘버링'
   COMMENT ON COLUMN "SE_MEMBER"."USER_ID" IS '아이디'
   COMMENT ON COLUMN "SE_MEMBER"."CREATE_DATE" IS '생성일시'
   COMMENT ON COLUMN "SE_MEMBER"."DEL_FLAG" IS '0삭제 1활성'
REM INSERTING into SE_MEMBER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SE_MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SE_MEMBER_PK" ON "SE_MEMBER" ("USER_CNO")
--------------------------------------------------------
--  Constraints for Table SE_MEMBER
--------------------------------------------------------

  ALTER TABLE "SE_MEMBER" ADD CONSTRAINT "SE_MEMBER_PK" PRIMARY KEY ("USER_CNO")
  USING INDEX  ENABLE
  ALTER TABLE "SE_MEMBER" MODIFY ("USER_CNO" NOT NULL ENABLE)

--------------------------------------------------------
--  DML for Index SE_MEMBER_PK
--------------------------------------------------------
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('관리자','1IDhAV4tBWxk621x9p+fvuJc0OTmj/earTv9i+uZgz8=','관리자',1,'admin',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('테스트1','S87LOGR/s41AnHepne5SzkDd6TxASwumvc2DEp3wYVw=','테스트1',2,'testid1',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('테스트2','a7Sn/vheSr3hs3eihRoA3YKJNnjrC2An/jj1TKSeFgE=','테스트2',3,'testid2',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('사용자1','iLDNzA6V4L6G+VmuTUu8VNHRpFewceUr9GiMuTdLg50=','사용자1',4,'user0001',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('사용자2','Tluq8P3BzZGxYsvME9PTSJ6rsSMEZsHZv76UkHI1aZU=','사용자2',5,'user0002',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('사용자3','DHV7pwPbGm6hIhMp8AP33nYRPb3nJvEVBd7aGHDlW/E=','사용자3',6,'user0003',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('사용자4','m8djXiWiGJp6J2Qj75BMRhDODgQbzBLIJ3Yh8CKdfvQ=','사용자4',7,'user0004',to_date('22/08/21','RR/MM/DD'),'1');
Insert into SE_MEMBER (USER_NAME,PASSWORD,NAME,USER_CNO,USER_ID,CREATE_DATE,DEL_FLAG) values ('사용자5','2NtOTJsxHtjhFhn5T+/DN53Rd7L2tztvr/G1BuEJS40=','사용자5',8,'user0005',to_date('22/08/21','RR/MM/DD'),'1');
