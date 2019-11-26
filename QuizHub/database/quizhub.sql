
----- DROP TABLE -----
--ALTER TABLE teachers DROP CONSTRAINT teacher;
DROP TABLE students;
DROP TABLE teachers;
DROP TABLE choices;
DROP TABLE quiz;
DROP TABLE questions;
DROP TABLE branch;
DROP TABLE faculty;
DROP TABLE comments;
DROP TABLE REPLY_COMMENTS;
DROP TABLE courses;
DROP TABLE admins;
DROP TABLE CHOICE_RESULTS;
DROP TABLE RESULTS;

----- CREATE STUDENT TABLE -----

CREATE TABLE STUDENTS
(
    STUDENT_ID BIGINT NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    FACULTY_ID INTEGER NOT NULL,
    BRANCH_ID INTEGER NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    ACCOUNT_STATUS VARCHAR(24) DEFAULT 'active' NOT NULL,
    LAST_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (STUDENT_ID));

----- CREATE TEACHERS TABLE -----

CREATE TABLE TEACHERS
(
    TEACHER_ID BIGINT NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    FACULTY_ID INTEGER NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    ACCOUNT_STATUS VARCHAR(24) DEFAULT 'pending' NOT NULL,
    LAST_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (TEACHER_ID));

----- CREATE BRANCH TABLE -----

CREATE TABLE BRANCH 
(
    BRANCH_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    BRANCH_NAME VARCHAR(128) NOT NULL,
    FACULTY_ID INTEGER NOT NULL,
    PRIMARY KEY (BRANCH_ID));

----- CREATE FACULTY TABLE -----

CREATE TABLE FACULTY 
(
    FACULTY_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    FACULTY_NAME VARCHAR(128) NOT NULL,
    PRIMARY KEY (FACULTY_ID));

----- CREATE QUIZ TABLE -----

CREATE TABLE QUIZ
(
    QUIZ_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    QUIZ_NAME VARCHAR(255) NOT NULL,
    QUIZ_COMMENTS VARCHAR(128) NOT NULL,
    QUIZ_STATUS VARCHAR(24) DEFAULT 'public' NOT NULL,
    TEACHER_ID BIGINT NOT NULL,
    COURSE_NAME VARCHAR(255) NOT NULL,
    COURSE_ID VARCHAR(24) NOT NULL,
    FACULTY_ID INTEGER NOT NULL,
    BRANCH_ID INTEGER NOT NULL,
    JOIN_CODE VARCHAR(12),
    COVER_IMAGES VARCHAR(128),
    SKILL_TEXT VARCHAR(128),
    START_DATE TIMESTAMP NOT NULL, 
    END_DATE TIMESTAMP NOT NULL,
    PAGE VARCHAR(128) NOT NULL,
    HOURS VARCHAR(128) NOT NULL,
    MINUTES VARCHAR(128) NOT NULL,
PRIMARY KEY (QUIZ_ID));

----- CREATE QUESTIONS TABLE -----

CREATE TABLE QUESTIONS
(
    QUESTION_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    QUESTION_NAME VARCHAR(255) NOT NULL,
    QUIZ_ID INTEGER NOT NULL,
PRIMARY KEY (QUESTION_ID));

----- CREATE CHOICES TABLE -----

CREATE TABLE CHOICES
(
    CHOICE_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    CHOICE_NAME VARCHAR(128) NOT NULL,
    CHOICE_CORRECT VARCHAR(128) DEFAULT 'false' NOT NULL,
    QUESTION_ID INTEGER NOT NULL,
    QUIZ_ID INTEGER NOT NULL,
PRIMARY KEY (CHOICE_ID));

----- CREATE Comment TABLE -----

CREATE TABLE COMMENTS
(
    COMMENT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    COMMENT VARCHAR(1024) NOT NULL,
    COMMENT_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    STUDENT_ID BIGINT NOT NULL,
    QUIZ_ID INTEGER NOT NULL,
PRIMARY KEY (COMMENT_ID));

----- CREATE CHOICES TABLE -----

CREATE TABLE REPLY_COMMENTS
(
    REPLY_COMMENT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    REPLY_COMMENT VARCHAR(1024) NOT NULL,
    STUDENT_ID BIGINT NOT NULL,
    COMMENT_ID INTEGER NOT NULL,
    REPLY_COMMENT_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
PRIMARY KEY (REPLY_COMMENT_ID));

----- CREATE CHOICES TABLE -----

CREATE TABLE COURSES
(
    COURSE_ID VARCHAR(24) NOT NULL,
    COURSE_NAME VARCHAR(255) NOT NULL,
    TEACHER BIGINT NOT NULL, 
PRIMARY KEY (COURSE_ID));
--ALTER TABLE COURSES
--ADD FOREIGN KEY (TEACHER) REFERENCES TEACHERS(TEACHER_ID);

----- CREATE ADMIN TABLE -----

CREATE TABLE ADMINS
(
    ADMIN_ID BIGINT NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    LAST_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (ADMIN_ID));

------ CREATE ANSWER TABLE -----
CREATE TABLE CHOICE_RESULTS
(
    CHOICE_RESULT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    QUIZ_ID INTEGER NOT NULL,
    QUESTION_ID INTEGER NOT NULL,
    CHOICE_ID INTEGER NOT NULL,
    STUDENT_ID BIGINT NOT NULL,
PRIMARY KEY (CHOICE_RESULT_ID));


--------- RESULT ---------
CREATE TABLE RESULTS
(
    RESULT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    TOTAL_TIME VARCHAR(255) NOT NULL,
    TOTAL_CORRECT INTEGER NOT NULL,
    TOTAL_INCORRECT INTEGER NOT NULL,
    QUIZ_ID INTEGER NOT NULL,
    STUDENT_ID BIGINT NOT NULL,
    RESULT_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (RESULT_ID));
