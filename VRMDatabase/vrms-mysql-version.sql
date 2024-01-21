
CREATE DATABASE IF NOT EXISTS videorentalstore;

CREATE TABLE role_details (
role_id varchar(10) NOT null,
role_name varchar(25) NOT null,
role_desc varchar(50),
access_page varchar(50)
);


CREATE TABLE COMPANY_DETAILS (
company_id varchar(10) NOT null,
company_name varchar(20) NOT null,
company_desc varchar(100),
REGISTERED_NUM varchar(10),
phone varchar(10),
address_line1 varchar(10),
address_line2 varchar(10),
city varchar(10),
state varchar(10),
country varchar(10),
zipcode varchar(6),
CREATED_BY int(20) NOT NULL,
CREATED_DATE date not null ,
LAST_MODIFIED_BY int (20) NOT NULL,
LAST_MODIFIED_DATE date not null
company_logo blob,
company_image blob
);


CREATE TABLE USER_SECURITY (
USERNAME VARCHAR(50) NOT NULL,
PASSWORD VARCHAR(20) NOT NULL,
STATUS VARCHAR(10) NOT NULL,
USER_ID VARCHAR(10) NOT NULL,
CREATED_BY int(20) NOT NULL,
CREATED_DATE date not null ,
LAST_MODIFIED_BY int (20) NOT NULL,
LAST_MODIFIED_DATE date not null
);


CREATE TABLE USER_DETAILS(
USER_ID varchar(20) NOT NULL,
USER_NAME varchar(50) NOT NULL,
EMAIL varchar(50) NOT NULL,
FIRST_NAME varchar(20) NOT NULL,
LAST_NAME varchar(20) NOT NULL,
SEX varchar(1),
MOBILE varchar(10) NOT NULL,
MOBILE2 varchar(10),
PHONE varchar(15),
CITY varchar(20),
STATE varchar(20),
COUNTRY varchar(20),
ZIPCODE varchar(6),
ADDRESS_LINE1 varchar(20),
ADDRESS_LINE2 varchar(20),
ADDRESS_LINE3 varchar(30),
CREATED_BY int(10)  NOT NULL,
CREATED_DATE DATE NOT NULL,
LAST_MODIFIED_BY int(10) NOT NULL,
LAST_MODIFIED_DATE DATE NOT NULL,
PICTURE BLOB,
STATUS varchar(10),
ROLE_ID INT,
COMPANY_ID INT,
AADHAAR varchar(12)
);


CREATE TABLE CUSTOMER_DETAILS (
  CUSTOMER_ID int(10) NOT NULL ,
  VRMS_ID varchar(20) NOT NULL,
  FIRST_NAME varchar(45) NOT NULL,
  LAST_NAME varchar(45) NOT NULL,
  EMAIL varchar(45) NOT NULL,
  ADDRESS_line1 varchar(100) DEFAULT NULL,
  ADDRESS_line2 varchar(100) DEFAULT NULL,
  ADDRESS_line3 varchar(100) DEFAULT NULL,
  PHONE varchar(10) DEFAULT NULL,
  MOBILE varchar(10) NOT NULL,
  CREATED_BY int(10) NOT NULL,
  CREATED_DATE date not null,
  LAST_MODIFIED_BY int(10) NOT NULL,
  LAST_MODIFIED_DATE date not null ,
  STATUS varchar(10) NOT NULL,
  company_id varchar(10),
  agent_code int(10),
  picture blob,
  aadhaar varchar(12),
  PRIMARY KEY (CUSTOMER_ID)
) ;

CREATE TABLE CATEGORIES (
  CATEGORY_ID int(10)  NOT NULL,
  CATEGORY_NAME varchar(45) NOT NULL,
  CATEGORY_DESC varchar(100),
  bonus int,
  active_PRICE int(3) NOT NULL,
  initial_PRICE int(3) NOT NULL,
  company_id varchar(10),
  agent_code varchar(10),
  CREATED_BY int(20) NOT NULL,
  CREATED_DATE DATE NOT NULL,
  LAST_MODIFIED_BY int(20) NOT NULL,
  LAST_MODIFIED_DATE DATE NOT NULL,
  STATUS varchar(10) NOT NULL
);

CREATE TABLE MOVIE_details (
  MOVIE_ID int(10)  NOT NULL ,
  MOVIE_NAME varchar(20) NOT NULL,
  MOVIE_DESC varchar(100) DEFAULT NULL,
  status varchar(8),
  agent_code int,
  total_COPIES int,
  available_copies int,
  CREATED_BY int(10)  NOT NULL,
  CREATED_DATE DATE  NOT NULL,
  LAST_MODIFIED_BY int(10)  NOT NULL,
  LAST_MODIFIED_DATE DATE  NOT NULL,
  picture BLOB,
  CATEGORY_ID int(10),
  company_id int(10),
  PRIMARY KEY (MOVIE_ID));



CREATE TABLE RENTAL_DETAILS (
  RENTAL_DETAILS_ID int(10) NOT NULL,
  RENTAL_ID varchar(10) NOT NULL,
  CUSTOMER_ID int(10) NOT NULL,
  MOVIE_ID int(10) NOT NULL,
  RENTAL_DATE DATE  NOT NULL,
  EXPECTED_RETURN_DATE DATE NOT NULL,
  ACTUAL_RETURN_DATE DATE NOT NULL,
  BONUS_POintS int(10)  NOT NULL,
  BONUS_STATUS varchar(10) NOT NULL,
  LATE_CHARGES int(10)  NOT NULL,
  charges int(10),
  status varchar(10),
  comments varchar(100),
  agent_code int(20),
  company_code varchar(10),
  PRIMARY KEY (RENTAL_DETAILS_ID));
  
 INSERT INTO USER_SECURITY (username,PASSWORD,status,USER_ID,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE)
 VALUES ('upender0209@gmail.com', 'chinni','A','upenderm',1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP);
 
 INSERT INTO USER_DETAILS values ('upenderm', 'upender0209@gmail.com', 'upender0209@gmail.com', 'Upender', 'Mamindlapelly', 'M', '9849613769',
NULL,NULL,null,NULL,NULL,null,null,null,null,'1',CURRENT_TIMESTAMP,'1',CURRENT_TIMESTAMP,null,'A','1','1',null);

INSERT INTO company_details (company_id, company_name) VALUES (1, 'ABC');
INSERT INTO role_details (role_id, role_name) VALUES (1,'ADMIN');


INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (1,'MATRIX 11','MATRIX 11',1,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:58:16');
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (2,'SPIDERMAN','SPIDERMAN',2,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:58:43');
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (3,'SPIDERMAN 2','SPIDERMAN 2',2,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:59:00');
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (5,'OUT OF AFRICA','OUT OF AFRICA',3,5,1,'2014-04-30 23:49:01',1,'2014-04-30 18:59:23');
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (6,'X-MEN VOLVERINE','X-MEN VOLVERINE',1,5,1,'2014-04-30 23:49:01',1,'2014-04-30 19:49:10');
INSERT INTO MOVIES (MOVIE_ID,MOVIE_NAME,MOVIE_DESC,CATEGORY_ID,COPIES,CREATED_BY,CREATED_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE) VALUES (7,'MID NIGHT MEAT TRAIN','MID NIGHT MEAT TRAIN',2,3,1,'2014-04-30 23:56:31',1,'2014-04-30 23:56:31');

 
insert into company_details (company_id,company_name,created_by,created_date,last_modified_by,last_modified_date) values (1,'ABC',1,curdate(),1,curdate()); 
 
 
 