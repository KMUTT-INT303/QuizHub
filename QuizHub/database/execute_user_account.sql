/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tsch
 * Created: Oct 19, 2019
 */


//--- Students ----//

INSERT INTO STUDENTS
	(STUDENT_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, BRANCH, LAST_TIME)
VALUES 
	(61130500001, 'demo', 'demo', 'demo', 'School of Information Technology', 'Information Technology', CURRENT_TIMESTAMP);
	
INSERT INTO STUDENTS
	(STUDENT_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, BRANCH, LAST_TIME)
VALUES 
	(61130500002, 'admin', 'admin', 'admin', 'School of Information Technology', 'Information Technology', CURRENT_TIMESTAMP);
	
INSERT INTO STUDENTS
	(STUDENT_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, BRANCH, LAST_TIME)
VALUES 
	(61130500003, 'ceno', 'ceno', 'ceno', 'School of Information Technology', 'Information Technology', CURRENT_TIMESTAMP);

// ---- Teachers ---- //

INSERT INTO TEACHERS
	(TEACHER_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, COURSE_NAME, COURSE_ID, LAST_TIME)
VALUES 
	(1000000001, 'John', 'Smith', '1234', 'School of Information Technology', 'Computer Programming', 'INT101', CURRENT_TIMESTAMP);
	
INSERT INTO TEACHERS
	(TEACHER_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, COURSE_NAME, COURSE_ID, LAST_TIME)
VALUES 
	(1000000002, 'Sim', 'Gight', '1234', 'School of Information Technology', 'Web Programming', 'INT303', CURRENT_TIMESTAMP);
	
INSERT INTO TEACHERS
	(TEACHER_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY, COURSE_NAME, COURSE_ID, LAST_TIME)
VALUES 
	(1000000003, 'Zea', 'Pual', '1234', 'School of Information Technology', 'Network I', 'INT201', CURRENT_TIMESTAMP);

