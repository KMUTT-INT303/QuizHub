
--- INSERT STUDENTS DATA ---

INSERT INTO STUDENTS
	(STUDENT_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY_ID, BRANCH_ID, EMAIL, LAST_TIME)
VALUES 
	(61130500001, 'Student', 'A', '1234', 2, 18, 'int303.quizhub@gmail.com', CURRENT_TIMESTAMP),
        (61130500002, 'Student', 'B', '1234', 2, 18, 'sa@gmail.com', CURRENT_TIMESTAMP),
        (61130500003, 'Student', 'C', '1234', 2, 18, 'sb@gmail.com', CURRENT_TIMESTAMP);

--- INSERT TEACHERS DATA ---
	
INSERT INTO TEACHERS
	(TEACHER_ID, FIRST_NAME, LAST_NAME, PASSWORD, FACULTY_ID, EMAIL, LAST_TIME)
VALUES
	(1000000001, 'Teacher', 'A', '1234', 2, 'int303.quizhub@gmail.com', CURRENT_TIMESTAMP),
        (1000000002, 'Teacher', 'B', '1234', 2, 'tb@gmail.com', CURRENT_TIMESTAMP),
        (1000000003, 'Teacher', 'C', '1234', 2, 'tc@gmail.com', CURRENT_TIMESTAMP),
        (1000000004, 'Teacher', 'D', '1234', 2, 'td@gmail.com', CURRENT_TIMESTAMP);
UPDATE TEACHERS SET account_status = 'active' WHERE teacher_id = 1000000001;

--- INSERT FACULTY DATA ---

INSERT INTO FACULTY
        (FACULTY_NAME)
VALUES
        ('Faculty of Industrial Education and Technology'), --- Automatic generated faculty Id 1 ---
        ('School of Information Technology'), --- Automatic generated faculty Id 2 ---
        ('Faculty of Science'), --- Automatic generated faculty Id 3 ---
        ('Faculty of Engineering'), --- Automatic generated faculty Id 4 ---
        ('School of Architecture and Design'), --- Automatic generated faculty Id 5 ---
        ('College of Multidisciplinary Sciences'); --- Automatic generated faculty Id 6 ---

--- INSERT BRANCH DATA ---
    
INSERT INTO BRANCH
        (BRANCH_NAME, FACULTY_ID)
VALUES    

        --- Faculty of Industrial Education and Technology ---

        ('Applied Computer Science-Multimedia', 1), -- ID 1
        ('Civil Engineering', 1), -- ID 2
        ('Education Technology and Mass Communication', 1), -- ID 3
        ('Electrical Engineering-Computer', 1), -- ID 4
        ('Electrical Engineering-Electrical Power', 1), -- ID 5
        ('Electrical Engineering-Electronics', 1), -- ID 6
        ('Industrial Technology ( Civil )', 1), -- ID 7
        ('Industrial Technology ( Electircal )', 1), -- ID 8
        ('Industrial Technology ( Mechanical )', 1), -- ID 9
        ('Industrial Technology ( Production)', 1), -- ID 10
        ('Mechanical Engineering', 1), -- ID 11
        ('Media Arts', 1), -- ID 12
        ('Media Technology', 1), -- ID 13
        ('Medical and Science Media', 1), -- ID 14
        ('Printing and Packaging Technology', 1), -- ID 15
        ('Production Engineering', 1), -- ID 16

        --- School of Information Technology ---

        ('Computer Science ( English Program )', 2), -- ID 17
        ('Information Technology', 2), -- ID 18
        ('Digital Service Innovation', 2), -- ID 19
        
        --- Faculty of Science --- 

        ('Mathematics', 3), -- ID 20
        ('Chemistry', 3), -- ID 21
        ('Applied Physics', 3), -- ID 21
        ('Microbiology', 3), -- ID 23
        ('Applied Computer Science', 3), -- ID 24
        ('Applied Statistics', 3), -- ID 25 
        ('Food Science and Technology', 3), -- ID 26

        --- Faculty of Engineering ---

        ('Automation Engineering (International Program)', 4), -- ID 27
        ('Chemical Engineering', 4), -- ID 28
        ('Chemical Engineering (International Program)', 4), -- ID 29
        ('Civil Engineering', 4), -- ID 30
        ('Civil Engineering (International Program)', 4), -- ID 31
        ('Computer Engineering', 4), -- ID 32
        ('Computer Engineering (International Program)', 4), -- ID 33
        ('Control System and Instrumentation Engineering', 4), -- ID 34
        ('Control System and Instrumentation Engineering(Co-operative Education)', 4), -- ID 35
        ('Electrical Communication and Electronic Engineering (International Program)', 4), -- ID 36
        ('Electrical Engineering', 4), -- ID 37
        ('Electrical Engineering (Power System , Power Electronics and Energy)', 4), -- ID 38
        ('Electronics and Telecommunication Engineering', 4), -- ID 39
        ('Environmental Engineering', 4), -- ID 40

        --- School of Architecture and Design ---

        ('Architecture (International Program)', 5), -- ID 41 
        ('Interior Architecture (International Program)', 5), -- ID 42
        ('Industrial Design (International Program)', 5), -- ID 43
        ('Communication Design (International Program)', 5), -- ID 44
        
        --- College of Multidisciplinary Sciences -- 

        ('Science and Technology', 6); -- ID 45

--- INSERT COURSES DATA ---
	
INSERT INTO COURSES
	(COURSE_ID, COURSE_NAME, TEACHER)
VALUES 
	('INT201', 'Network I', 1000000001),
        ('INT303', 'Web Programming', 1000000004);

--- INSERT ADMINS DATA ---
	
INSERT INTO ADMINS
	(ADMIN_ID, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES 
	(000, 'ADMIN', 'IS GOD', '000');

INSERT INTO QUIZ 
        (QUIZ_NAME, QUIZ_COMMENTS, QUIZ_STATUS, TEACHER_ID, COURSE_NAME, COURSE_ID, FACULTY_ID, BRANCH_ID, JOIN_CODE, COVER_IMAGES, SKILL_TEXT, START_DATE, END_DATE, PAGE, HOURS, MINUTES) 
VALUES ('Network Programming', 'Please attention', 'public', 1000000001, 'Network I', 'INT201', 2, 18, '', '', 'Network', '2019-11-13 20:29:46.435', '2019-11-13 20:29:47.654', 'HRVIDPZG6G', '5', '00'),
        ('Gen Programming', 'Please attention', 'public', 1000000001, 'Web Programing', 'INT303', 2, 18, '', '', 'Network', '2019-11-13 20:29:46.435', '2019-11-13 20:29:47.654', 'R3V9RAOUPJ', '10', '00'),
        ('Program Programming', 'Please attention', 'public', 1000000001, 'Network I', 'INT201', 2, 18, '', '', 'Network', '2019-11-13 20:29:46.435', '2019-11-13 20:29:47.654', 'EMWO7GGBSM', '10', '00'),
        ('Eng Programming', 'Please attention', 'public', 1000000001, 'Network I', 'INT201', 2, 18, '', '', 'Network', '2019-11-13 20:29:46.435', '2019-11-13 20:29:47.654', '6TA8MMBDDG', '30', '00'),
        ('GG Programming', 'Please attention', 'public', 1000000001, 'Network I', 'INT201', 2, 18, '', '', 'Network', '2019-11-13 20:29:46.435', '2019-11-13 20:29:47.654', '8E4QKLU4JA', 'unlimited', 'unlimited');

--- INSERT QUESTION ---
INSERT INTO QUIZHUB.QUESTIONS (QUESTION_NAME, QUIZ_ID) 
	VALUES ('What is QuizHub?', 1);
INSERT INTO QUIZHUB.QUESTIONS (QUESTION_NAME, QUIZ_ID) 
	VALUES ('Is INT303 easy?', 1);

--- INSERT CHOICE ---
INSERT INTO QUIZHUB.CHOICES (CHOICE_NAME, CHOICE_CORRECT, QUESTION_ID, QUIZ_ID) 
	VALUES ('QuizHub is the best web quiz.', 'true', 1, 1);
INSERT INTO QUIZHUB.CHOICES (CHOICE_NAME, CHOICE_CORRECT, QUESTION_ID, QUIZ_ID) 
	VALUES ('QuizHub is cat name.', 'false', 1, 1);
INSERT INTO QUIZHUB.CHOICES (CHOICE_NAME, CHOICE_CORRECT, QUESTION_ID, QUIZ_ID) 
	VALUES ('Quiz', 'false', 1, 1);
INSERT INTO QUIZHUB.CHOICES (CHOICE_NAME, CHOICE_CORRECT, QUESTION_ID, QUIZ_ID) 
	VALUES ('Yes', 'false', 2, 1);
INSERT INTO QUIZHUB.CHOICES (CHOICE_NAME, CHOICE_CORRECT, QUESTION_ID, QUIZ_ID) 
	VALUES ('No', 'true', 2, 1);


