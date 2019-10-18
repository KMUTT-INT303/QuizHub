--------------------------------------------------------
--  File created - Friday-October-18-2019   
--------------------------------------------------------
DROP TABLE "Quizhub"."CHOICES";
--------------------------------------------------------
--  DDL for Table CHOICES
--------------------------------------------------------

  CREATE TABLE "Quizhub"."CHOICES" 
   (	"CHOICE_ID" NUMBER(38,0), 
	"CHOICE_NAME" VARCHAR2(255 BYTE), 
	"CHOICE_CORRECT" NUMBER(1,0) DEFAULT ('1'), 
	"QUESTION_ID" NUMBER(38,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into Quizhub.CHOICES
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index CHOICES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "Quizhub"."CHOICES_PK" ON "Quizhub"."CHOICES" ("CHOICE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CHOICES
--------------------------------------------------------

  ALTER TABLE "Quizhub"."CHOICES" ADD CONSTRAINT "CHOICES_PK" PRIMARY KEY ("CHOICE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "Quizhub"."CHOICES" MODIFY ("CHOICE_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."CHOICES" MODIFY ("CHOICE_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."CHOICES" MODIFY ("CHOICE_CORRECT" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."CHOICES" MODIFY ("QUESTION_ID" NOT NULL ENABLE);


--------------------------------------------------------
--  File created - Friday-October-18-2019   
--------------------------------------------------------
DROP TABLE "Quizhub"."QUESTIONS";
--------------------------------------------------------
--  DDL for Table QUESTIONS
--------------------------------------------------------

  CREATE TABLE "Quizhub"."QUESTIONS" 
   (	"QUESTION_ID" NUMBER(38,0), 
	"QUESTION_NAME" VARCHAR2(255 BYTE), 
	"QUESTION_NUMBER" VARCHAR2(255 BYTE), 
	"QUESTION_PICTURE" VARCHAR2(255 BYTE), 
	"QUIZ_ID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into Quizhub.QUESTIONS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index QUESTIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "Quizhub"."QUESTIONS_PK" ON "Quizhub"."QUESTIONS" ("QUESTION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table QUESTIONS
--------------------------------------------------------

  ALTER TABLE "Quizhub"."QUESTIONS" ADD CONSTRAINT "QUESTIONS_PK" PRIMARY KEY ("QUESTION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "Quizhub"."QUESTIONS" MODIFY ("QUESTION_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUESTIONS" MODIFY ("QUESTION_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUESTIONS" MODIFY ("QUESTION_NUMBER" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUESTIONS" MODIFY ("QUIZ_ID" NOT NULL ENABLE);

--------------------------------------------------------
--  File created - Friday-October-18-2019   
--------------------------------------------------------
DROP TABLE "Quizhub"."QUIZ";
--------------------------------------------------------
--  DDL for Table QUIZ
--------------------------------------------------------

  CREATE TABLE "Quizhub"."QUIZ" 
   (	"QUIZ_ID" NUMBER(20,0), 
	"QUIZ_NAME" VARCHAR2(255 BYTE), 
	"QUIZ_COMMENTS" VARCHAR2(255 BYTE), 
	"QUIZ_STATUS" VARCHAR2(255 BYTE) DEFAULT ('Open'), 
	"TEACHER_ID" NUMBER(20,0), 
	"COURSE_NAME" VARCHAR2(255 BYTE), 
	"COURSE_ID" VARCHAR2(255 BYTE), 
	"JOIN_CODE" VARCHAR2(255 BYTE), 
	"COVER_IMAGES" VARCHAR2(255 BYTE), 
	"START_DATE" TIMESTAMP (6), 
	"END_DATE" TIMESTAMP (6)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into Quizhub.QUIZ
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index QUIZ_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "Quizhub"."QUIZ_PK" ON "Quizhub"."QUIZ" ("QUIZ_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table QUIZ
--------------------------------------------------------

  ALTER TABLE "Quizhub"."QUIZ" ADD CONSTRAINT "QUIZ_PK" PRIMARY KEY ("QUIZ_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("QUIZ_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("QUIZ_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("QUIZ_STATUS" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("TEACHER_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("COURSE_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("COURSE_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."QUIZ" MODIFY ("START_DATE" NOT NULL ENABLE);

--------------------------------------------------------
--  File created - Friday-October-18-2019   
--------------------------------------------------------
DROP TABLE "Quizhub"."STUDENTS";
--------------------------------------------------------
--  DDL for Table STUDENTS
--------------------------------------------------------

  CREATE TABLE "Quizhub"."STUDENTS" 
   (	"ID" NUMBER(20,0), 
	"STUDENT_ID" VARCHAR2(255 BYTE), 
	"FIRST_NAME" VARCHAR2(255 BYTE), 
	"LAST_NAME" VARCHAR2(255 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"FACULTY" VARCHAR2(255 BYTE), 
	"BRANCH" VARCHAR2(255 BYTE), 
	"ACCOUNT_STATUS" VARCHAR2(255 BYTE) DEFAULT ('Actived'), 
	"LAST_TIME" TIMESTAMP (6)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into Quizhub.STUDENTS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index STUDENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "Quizhub"."STUDENTS_PK" ON "Quizhub"."STUDENTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table STUDENTS
--------------------------------------------------------

  ALTER TABLE "Quizhub"."STUDENTS" ADD CONSTRAINT "STUDENTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("STUDENT_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("FACULTY" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("BRANCH" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."STUDENTS" MODIFY ("ACCOUNT_STATUS" NOT NULL ENABLE);

--------------------------------------------------------
--  File created - Friday-October-18-2019   
--------------------------------------------------------
DROP TABLE "Quizhub"."TEACHERS";
--------------------------------------------------------
--  DDL for Table TEACHERS
--------------------------------------------------------

  CREATE TABLE "Quizhub"."TEACHERS" 
   (	"ID" NUMBER(38,0), 
	"TEACHER_ID" NUMBER(38,0), 
	"FIRST_NAME" VARCHAR2(255 BYTE), 
	"LAST_NAME" VARCHAR2(255 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"FACULTY" VARCHAR2(255 BYTE), 
	"COURSE_NAME" VARCHAR2(255 BYTE), 
	"COURSE_ID" VARCHAR2(255 BYTE), 
	"ACCOUNT_STATUS" VARCHAR2(255 BYTE) DEFAULT ('Pending'), 
	"LAST_TIME" TIMESTAMP (6)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into Quizhub.TEACHERS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index TEACHERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "Quizhub"."TEACHERS_PK" ON "Quizhub"."TEACHERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TEACHERS
--------------------------------------------------------

  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("TEACHER_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("FACULTY" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("COURSE_NAME" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("COURSE_ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("ACCOUNT_STATUS" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "Quizhub"."TEACHERS" ADD CONSTRAINT "TEACHERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
