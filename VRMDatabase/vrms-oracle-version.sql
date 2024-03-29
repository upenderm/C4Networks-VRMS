
CREATE TABLE USER_SECURITY (
USERNAME VARCHAR2(50) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
STATUS VARCHAR2(10) NOT NULL,
CREATED_BY NUMBER(20) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY NUMBER(20) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL
);

CREATE TABLE CATEGORIES (
  CATEGORY_ID NUMBER(10)  NOT NULL,
  CATEGORY_NAME VARCHAR2(45) NOT NULL,
  CATEGORY_DESC VARCHAR2(100),
  PRICE NUMBER(3) NOT NULL,
  CREATED_BY NUMBER(20) NOT NULL,
  CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
  LAST_MODIFIED_BY NUMBER(20) NOT NULL,
  LAST_MODIFIED_DATE DATE DEFAULT SYSDATE NOT NULL,
  STATUS VARCHAR2(10) NOT NULL,
  PRIMARY KEY (CATEGORY_ID)
);


CREATE TABLE CUSTOMER_DETAILS (
  CUSTOMER_ID NUMBER(10) NOT NULL ,
  VRMS_ID VARCHAR2(20) NOT NULL,
  FIRST_NAME VARCHAR2(45) NOT NULL,
  LAST_NAME VARCHAR2(45) NOT NULL,
  EMAIL VARCHAR2(45) NOT NULL,
  ADDRESS VARCHAR2(100) DEFAULT NULL,
  PHONE VARCHAR2(10) DEFAULT NULL,
  MOBILE VARCHAR2(10) NOT NULL,
  CREATED_BY NUMBER(10) NOT NULL,
  CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
  LAST_MODIFIED_BY NUMBER(10) NOT NULL,
  LAST_MODIFIED_DATE DATE DEFAULT SYSDATE NOT NULL ,
  STATUS VARCHAR2(10) NOT NULL,
  PRIMARY KEY (CUSTOMER_ID)
) ;

CREATE TABLE MOVIES (
  MOVIE_ID NUMBER(10)  NOT NULL ,
  MOVIE_NAME VARCHAR2(50) NOT NULL,
  MOVIE_DESC VARCHAR2(100) DEFAULT NULL,
  CATEGORY_ID NUMBER(10)  NOT NULL,
  COPIES NUMBER(11) NOT NULL,
  CREATED_BY NUMBER(10)  NOT NULL,
  CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
  LAST_MODIFIED_BY NUMBER(10)  NOT NULL,
  LAST_MODIFIED_DATE DATE DEFAULT SYSDATE NOT NULL,
  PRIMARY KEY (MOVIE_ID));

CREATE TABLE RENTAL_DETAILS (
  RENTAL_DETAILS_ID NUMBER(10) NOT NULL,
  RENTAL_ID VARCHAR2(10) NOT NULL,
  CUSTOMER_ID NUMBER(10) NOT NULL,
  MOVIE_ID NUMBER(10) NOT NULL,
  RENTAL_DATE DATE DEFAULT SYSDATE NOT NULL,
  EXPECTED_RETURN_DATE DATE DEFAULT SYSDATE NOT NULL,
  ACTUAL_RETURN_DATE DATE DEFAULT SYSDATE NOT NULL,
  bonus_points NUMBER(10)  NOT NULL,
  BONUS_STATUS VARCHAR2(10) NOT NULL,
  LATE_CHARGES NUMBER(10)  NOT NULL,
  PRIMARY KEY (RENTAL_DETAILS_ID));

CREATE TABLE USER_DETAILS(
USER_ID VARCHAR2(20) NOT NULL,
USER_NAME VARCHAR2(50) NOT NULL,
EMAIL VARCHAR2(50) NOT NULL,
FIRST_NAME VARCHAR2(20) NOT NULL,
LAST_NAME VARCHAR2(20) NOT NULL,
SEX VARCHAR2(1),
MOBILE VARCHAR2(10) NOT NULL,
PHONE VARCHAR2(15),
CITY VARCHAR2(20),
STATE VARCHAR2(20),
COUNTRY VARCHAR2(20),
ZIPCODE VARCHAR2(6),
ADDRESSLINE1 VARCHAR2(20),
ADDRESSLINE2 VARCHAR2(20),
ADDRESSLINE3 VARCHAR2(30),
CREATED_BY NUMBER(10)  NOT NULL,
CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
LAST_MODIFIED_BY NUMBER(10) NOT NULL,
LAST_MODIFIED_DATE DATE DEFAULT SYSDATE NOT NULL,
PICTURE BLOB,
STATUS VARCHAR2(10),
AADHAAR VARCHAR2(12)
);

CREATE TABLE COMPANY_DETAILS (
company_id varchar2(10) NOT null,
company_name varchar2(25) NOT null,
description varchar2(100)
);

CREATE TABLE COMPANY_DETAILS (
company_id varchar2(10) NOT null,
company_name varchar2(25) NOT null,
description varchar2(100)
);


CREATE TABLE role_details (
role_id varchar2(10) NOT null,
role_name varchar2(25) NOT null,
role_desc varchar2(50),
access_page varchar2(50)
);

create table c4_transactions (
	transaction_id varchar2(10) not null,
    transaction_date date default sysdate not null,
    transaction_amount varchar2(5) not null,
    transaction_category varchar2(20) not null,
    transaction_desc varchar2(50),
    constraint trnx_unique unique (transaction_id,transaction_category)
);


INSERT INTO CATEGORIES (CATEGORY_ID,CATEGORY_NAME,CATEGORY_DESC,PRICE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES 
 (1,'NEW RELEASES','NEW RELEASES',40,1,TO_DATE('2014-04-30 17:35:56','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 17:15:14','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CATEGORIES (CATEGORY_ID,CATEGORY_NAME,CATEGORY_DESC,PRICE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES 
 (2,'REGULAR FILMS','REGULAR FILMS',30,1,TO_DATE('2014-04-30 17:36:03','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 17:16:02','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CATEGORIES (CATEGORY_ID,CATEGORY_NAME,CATEGORY_DESC,PRICE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES 
 (3,'OLD FILMS','OLD FILMS',30,1,TO_DATE('2014-04-30 17:36:07','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 17:16:03','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');

SELECT * FROM USER_SECURITY us ;
INSERT INTO USER_SECURITY (username,PASSWORD,status,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE)
 VALUES ('upender0209@gmail.com', 'chinni','A',1,sysdate,1,sysdate);


INSERT INTO company_details (company_id, company_name) VALUES (1, 'ABC');
INSERT INTO role_details (role_id, role_name) VALUES (1,'ADMIN');


INSERT INTO USER_DETAILS values ('upenderm', 'upender0209@gmail.com', 'upender0209@gmail.com', 'Upender', 'Mamindlapelly', 'M', '9849613769', 
NULL,NULL,null,NULL,NULL,null,null,null,null,'1',sysdate,'1',sysdate,null,'A','1','1',null);


INSERT INTO RENTAL_DETAILS (RENTAL_DETAILS_ID,RENTAL_ID,CUSTOMER_ID,MOVIE_ID,RENTAL_DATE,EXPECTED_RETURN_DATE,ACTUAL_RETURN_DATE,bonus_points,BONUS_STATUS,LATE_CHARGES) VALUES 
 (1,'RNT001',3,1,TO_DATE('2014-05-01 00:23:18','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:14:42','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:14:50','YYYY-MM-DD HH24:MI:SS'),2,'ACTIVE',0);
INSERT INTO RENTAL_DETAILS (RENTAL_DETAILS_ID,RENTAL_ID,CUSTOMER_ID,MOVIE_ID,RENTAL_DATE,EXPECTED_RETURN_DATE,ACTUAL_RETURN_DATE,bonus_points,BONUS_STATUS,LATE_CHARGES) VALUES 
 (2,'RNT002',2,2,TO_DATE('2014-05-01 00:23:32','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:19:32','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:19:32','YYYY-MM-DD HH24:MI:SS'),1,'ACTIVE',0);
INSERT INTO RENTAL_DETAILS (RENTAL_DETAILS_ID,RENTAL_ID,CUSTOMER_ID,MOVIE_ID,RENTAL_DATE,EXPECTED_RETURN_DATE,ACTUAL_RETURN_DATE,bonus_points,BONUS_STATUS,LATE_CHARGES) VALUES 
 (3,'RNT003',6,5,TO_DATE('2014-05-01 00:23:44','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:19:47','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-04-30 23:19:47','YYYY-MM-DD HH24:MI:SS'),1,'ACTIVE',0);
INSERT INTO RENTAL_DETAILS (RENTAL_DETAILS_ID,RENTAL_ID,CUSTOMER_ID,MOVIE_ID,RENTAL_DATE,EXPECTED_RETURN_DATE,ACTUAL_RETURN_DATE,bonus_points,BONUS_STATUS,LATE_CHARGES) VALUES 
 (4,'RNT004',5,5,TO_DATE('2014-05-01 00:29:29','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-05-01 00:29:29','YYYY-MM-DD HH24:MI:SS'),TO_DATE('2014-05-01 00:29:29','YYYY-MM-DD HH24:MI:SS'),1,'ACTIVE',0);


INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES 
(1,'VRMS001','ADMIN','SUPER','ADMIN@VRM.COM','HYDERABAD','67576375','9849613769',1,TO_DATE('2014-05-01 00:08:58','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 15:35:30','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES
(2,'VRMS002','UPENDER','M','UPENDER@GMAIL.COM','HYDERABAD','66668888','9849613769',1,TO_DATE('2014-05-01 00:09:08','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 16:12:13','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES
(3,'VRMS003','KANAKALAXMI','PINNOJU','KLAXMI.PINNOJU@GMAIL.COM','KARIMNAGAR','','9705406390',1,TO_DATE('2014-05-01 00:09:14','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 16:14:32','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES
(4,'VRMS004','UPENDER','MAMINDLAPELLY','UPENDER0209@GMAIL.COM','WARANGAL','','984949494',1,TO_DATE('2014-05-01 00:09:19','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 16:17:13','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES
(5,'VRMS005','FNAME','LNAME','TEST@VRM.COM','MYADDRESS','33939','989898989',1,TO_DATE('2014-05-01 00:09:25','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 17:02:21','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');
INSERT INTO CUSTOMER_DETAILS (CUSTOMER_ID,VRMS_ID,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,PHONE,MOBILE,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE,STATUS) VALUES
(6,'VRMS006','JOHNSON','BEN','JOHNSON.BEN@ADP.COM','ROSELAND','3933333','231568849',1,TO_DATE('2014-05-01 00:09:51','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 19:50:34','YYYY-MM-DD HH24:MI:SS'),'ACTIVE');


INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (1,'MATRIX 11','MATRIX 11',1,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 18:58:16','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (2,'SPIDERMAN','SPIDERMAN',2,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 18:58:43','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (3,'SPIDERMAN 2','SPIDERMAN 2',2,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 18:59:00','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (4,'BLADERUNNER','BLADERUNNER',3,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 18:59:11','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (5,'OUT OF AFRICA','OUT OF AFRICA',3,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 18:59:23','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (6,'X-MEN VOLVERINE','X-MEN VOLVERINE',1,5,1,TO_DATE('2014-04-30 23:49:01','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 19:49:10','YYYY-MM-DD HH24:MI:SS'));
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (7,'MID NIGHT MEAT TRAIN','MID NIGHT MEAT TRAIN',2,3,1,TO_DATE('2014-04-30 23:56:31','YYYY-MM-DD HH24:MI:SS'),1,TO_DATE('2014-04-30 23:56:31','YYYY-MM-DD HH24:MI:SS'));



COMMIT;