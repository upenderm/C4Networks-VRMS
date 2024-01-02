--
-- CREATE THE TABLES IN THE SAME ORDER. DO NOT REVAMP THE ORDER OF TABLES IN DDL SCRIPT.

CREATE TABLE C4_COMPANY_DETAILS (
COMPANY_OID VARCHAR2(16) NOT NULL,
COMPANY_ID VARCHAR2(20) NOT NULL,
COMPANY_NAME VARCHAR2(30) NOT NULL,
COMPANY_DESC VARCHAR2(100),
REGISTERED_NUMBER VARCHAR2(100),
MOBILE VARCHAR2(10),
MOBILE2 VARCHAR2(10),
PHONE VARCHAR2(10) NOT NULL,
ADDRESS_LINE1 VARCHAR2(100),
ADDRESS_LINE2 VARCHAR2(100),
CITY VARCHAR2(20),
STATE1 VARCHAR2(20),
COUNTRY VARCHAR2(20),
ZIPCODE VARCHAR2(6),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
COMPANY_LOGO BLOB,
COMPANY_IMAGE BLOB,
CONSTRAINT PK_C4CD_COMPANY_OID PRIMARY KEY (COMPANY_OID),
CONSTRAINT UK_C4CD_COMPANY_ID UNIQUE (COMPANY_ID)
);

CREATE TABLE C4_USER_SECURITY (
USER_OID VARCHAR2(16) NOT NULL,
USERNAME VARCHAR2(30) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
STATUS VARCHAR2(10) NOT NULL,
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
VERSION INT NOT NULL,
TEMP_USERNAME VARCHAR2(30),
CONSTRAINT PK_C4US_USER_OID PRIMARY KEY (USER_OID),
CONSTRAINT UK_C4US_USERNAME UNIQUE (USERNAME)
--CONSTRAINT FK_C4US_C4UD_1 FOREIGN KEY (CREATED_BY, LAST_MODIFIED_BY) REFERENCES C4_USER_DETAILS(C4_USER_OID, C4_USER_OID)
);

CREATE TABLE C4_ROLE_DETAILS (
ROLE_ID VARCHAR2(6) NOT NULL,
ROLE_NAME VARCHAR2(30) NOT NULL,
ROLE_DESC VARCHAR2(100), 
ACCESS_PAGE VARCHAR2(100),
COMPANY_OID VARCHAR2(16) NOT NULL,
CONSTRAINT PK_C4_ROLE_ID PRIMARY KEY (ROLE_ID),
CONSTRAINT FK_C4RD_C4CD_1 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID)
);

CREATE TABLE C4_USER_DETAILS (
C4_USER_OID VARCHAR2(16) NOT NULL,
USERNAME VARCHAR2(30) NOT NULL,
EMAIL VARCHAR2(30) NOT NULL,
FIRST_NAME VARCHAR2(20) NOT NULL,
MIDDLE_NAME VARCHAR2(20),
LAST_NAME VARCHAR2(20) NOT NULL,
SEX VARCHAR2(1),
MOBILE VARCHAR2(10) NOT NULL,
MOBILE2 VARCHAR2(10),
PHONE VARCHAR2(10),
CITY VARCHAR2(20),
STATE VARCHAR2(20),
COUNTRY VARCHAR2(20),
ZIPCODE VARCHAR2(6),
ADDRESS_LINE1 VARCHAR2(30),
ADDRESS_LINE2 VARCHAR2(30),
ADDRESS_LINE3 VARCHAR2(30),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
STATUS VARCHAR2(8),
PICTURE BLOB,
ROLE_ID VARCHAR2(6) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
DOCUMENT_ID VARCHAR2(12),
CONSTRAINT PK_C4UD_USER_OID PRIMARY KEY (C4_USER_OID),
CONSTRAINT UK_C4UD_USERNAME UNIQUE (USERNAME),
CONSTRAINT FK_C4UD_C4UD_1 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID),
CONSTRAINT FK_C4UD_C4RD_2 FOREIGN KEY (ROLE_ID) REFERENCES C4_ROLE_DETAILS(ROLE_ID)
);

CREATE TABLE VRMS_USER_DETAILS (
C4_USER_OID VARCHAR2(16) NOT NULL,
USERNAME VARCHAR2(30) NOT NULL,
EMAIL VARCHAR2(30) NOT NULL,
FIRST_NAME VARCHAR2(20) NOT NULL,
MIDDLE_NAME VARCHAR2(20),
LAST_NAME VARCHAR2(20) NOT NULL,
SEX VARCHAR2(1),
MOBILE VARCHAR2(10) NOT NULL,
MOBILE2 VARCHAR2(10),
PHONE VARCHAR2(10),
CITY VARCHAR2(20),
STATE VARCHAR2(20),
COUNTRY VARCHAR2(20),
ZIPCODE VARCHAR2(6),
ADDRESS_LINE1 VARCHAR2(30),
ADDRESS_LINE2 VARCHAR2(30),
ADDRESS_LINE3 VARCHAR2(30),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
STATUS VARCHAR2(8),
PICTURE BLOB,
ROLE_ID VARCHAR2(6) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
DOCUMENT_ID VARCHAR2(12),
CONSTRAINT PK_VRMSUD_USEROID PRIMARY KEY (C4_USER_OID),
CONSTRAINT UK_VRMSUD_USERNAME UNIQUE(USERNAME),
CONSTRAINT FK_VRMSUD_C4UD_1 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID),
CONSTRAINT FK_VRMSUD_C4RD_2 FOREIGN KEY (ROLE_ID) REFERENCES C4_ROLE_DETAILS(ROLE_ID)
);

CREATE TABLE VRMS_AGENT_CUSTOMER_DETAILS (
AG_CUST_OID VARCHAR2(16) NOT NULL,
AG_CUST_ID VARCHAR2(8) NOT NULL,
EMAIL VARCHAR2(30),
FIRST_NAME VARCHAR2(20) NOT NULL,
MIDDLE_NAME VARCHAR2(20),
LAST_NAME VARCHAR2(20) NOT NULL,
SEX VARCHAR2(1),
MOBILE VARCHAR2(10) NOT NULL,
MOBILE2 VARCHAR2(10),
PHONE VARCHAR2(10),
CITY VARCHAR2(20),
STATE VARCHAR2(20),
COUNTRY VARCHAR2(20),
ZIPCODE VARCHAR2(6),
ADDRESS_LINE1 VARCHAR2(30),
ADDRESS_LINE2 VARCHAR2(30),
ADDRESS_LINE3 VARCHAR2(30),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
STATUS VARCHAR2(8),
PICTURE BLOB,
ROLE_ID VARCHAR2(6) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
DOCUMENT_ID VARCHAR2(12),
CONSTRAINT PK_VRMSACD_AGCUSTOID PRIMARY KEY (AG_CUST_OID),
CONSTRAINT FK_VRMSACS_C4RD_1 FOREIGN KEY (ROLE_ID) REFERENCES C4_ROLE_DETAILS(ROLE_ID),
CONSTRAINT FK_VRMSACD_VRMSUD_2 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID)
);

CREATE TABLE VRMS_CATEGORY_DETAILS (
CATEGORY_ID VARCHAR2(6) NOT NULL,
CATEGORY_NAME VARCHAR2(30) NOT NULL,
CATEGORY_DESC VARCHAR2(100),
ACTIVE_PRICE NUMBER(6,2) NOT NULL,
INITIAL_PRICE NUMBER(6,2) NOT NULL,
STATUS VARCHAR2(10) NOT NULL,
BONUS NUMBER(6,2),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
CONSTRAINT PK_VRMS_CATDLS_ID PRIMARY KEY (CATEGORY_ID,COMPANY_OID),
CONSTRAINT FK_VRMSCAT_VRMSUD_1 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID)
--CONSTRAINT FK_VRMSCAT_VRMSUD_2 FOREIGN KEY (CREATED_BY, LAST_MODIFIED_BY) REFERENCES VRMS_USER_DETAILS(C4_USER_OID,C4_USER_OID),
);

CREATE TABLE VRMS_MOVIE_DETAILS (
MOVIE_ID VARCHAR2(6) NOT NULL,
MOVIE_NAME VARCHAR2(20) NOT NULL,
MOVIE_DESC VARCHAR2(100),
CATEGORY_ID VARCHAR2(6) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
STATUS VARCHAR2(8) NOT NULL,
TOTAL_COPIES INT NOT NULL,
AVAILABLE_COPIES NUMBER NOT NULL,
PICTURE BLOB,
CONSTRAINT PK_VRMSMD_MVCY_ID PRIMARY KEY (MOVIE_ID,COMPANY_OID),
CONSTRAINT FK_VRMSMD_VRMSCAT_1 FOREIGN KEY (CATEGORY_ID,COMPANY_OID) REFERENCES VRMS_CATEGORY_DETAILS(CATEGORY_ID,COMPANY_OID)
--CONSTRAINT FK_VRMSMD_VRMSUD_2 FOREIGN KEY (COMPANY_OID) REFERENCES VRMS_USER_DETAILS(COMPANY_OID)
--CONSTRAINT FK_VRMSMD_VRMSUD_3 FOREIGN KEY (CREATED_BY, LAST_MODIFIED_BY) REFERENCES VRMS_USER_DETAILS(C4_USER_OID,C4_USER_OID),
);

CREATE TABLE VRMS_RENTAL_DETAILS (
RENTAL_ID VARCHAR2(6) NOT NULL,
AG_CUST_OID VARCHAR2(16) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
MOVIE_ID VARCHAR2(5) NOT NULL,
RENTAL_DATE TIMESTAMP NOT NULL,
EXPECTED_RETURN_DATE TIMESTAMP NOT NULL,
ACTUAL_RETURN_DATE TIMESTAMP,
LATE_CHARGES NUMBER(6,2),
STATUS VARCHAR2(10) NOT NULL,
COMMENTS VARCHAR2(100),
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
CONSTRAINT PK_RNTDTLS_RNTCMPY_ID PRIMARY KEY (RENTAL_ID,COMPANY_OID),
CONSTRAINT FK_VRMSRNTD_VRMSACD_1 FOREIGN KEY (AG_CUST_OID) REFERENCES VRMS_AGENT_CUSTOMER_DETAILS(AG_CUST_OID),
CONSTRAINT FK_VRMSRNTD_VRMSMD_2 FOREIGN KEY (MOVIE_ID,COMPANY_OID) REFERENCES VRMS_MOVIE_DETAILS(MOVIE_ID,COMPANY_OID)
--CONSTRAINT FK_VRMSRNTD_VRMSUD_3 FOREIGN KEY (CREATED_BY, LAST_MODIFIED_BY) REFERENCES VRMS_USER_DETAILS(C4_USER_OID,C4_USER_OID)
);

CREATE TABLE VRMS_AGENT_BONUS_DTLS (
AG_BONUS_ID VARCHAR2(5) NOT NULL,
AG_CUST_OID VARCHAR2(16) NOT NULL,
COMPANY_OID VARCHAR2(16) NOT NULL,
BONUS_POINTS NUMBER NOT NULL,
BONUS_VERSION NUMBER NOT NULL,
CREATED_BY VARCHAR2(16) NOT NULL,
CREATED_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_BY VARCHAR2(16) NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
CONSTRAINT FK_VRMSABD_VRMSACD_1 FOREIGN KEY (AG_CUST_OID) REFERENCES VRMS_AGENT_CUSTOMER_DETAILS(AG_CUST_OID),
CONSTRAINT FK_VRMSABD_VRMSUD_2 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID)
--CONSTRAINT FK_VRMSABD_VRMSUD_3 FOREIGN KEY (CREATED_BY, LAST_MODIFIED_BY) REFERENCES VRMS_USER_DETAILS(C4_USER_OID,C4_USER_OID)
);

CREATE TABLE VRMS_TRNX_DETAILS (
TRANSACTION_ID VARCHAR2(16) NOT NULL,
TRANSACTION_DATE TIMESTAMP NOT NULL,
TRANSACTION_AMOUNT NUMBER(6,2) NOT NULL,
TRANSACTION_CATEGORY VARCHAR2(10),
TRANSACTION_DESC VARCHAR2(50),
COMPANY_OID VARCHAR2(16) NOT NULL,
CONSTRAINT FK_VRMSTRNX_VRMSUD_1 FOREIGN KEY (COMPANY_OID) REFERENCES C4_COMPANY_DETAILS(COMPANY_OID)
);


-- DELETE THE TABLES IN THE REVERSED ORDER. DO NOT REVAMP THE ORDER OF TABLES IN DELETE SCRIPT.

--DROP TABLE VRMS_TRNX_DETAILS;
--DROP TABLE VRMS_AGENT_BONUS_DTLS;
--DROP TABLE VRMS_RENTAL_DETAILS;
--DROP TABLE VRMS_MOVIE_DETAILS;
--DROP TABLE VRMS_CATEGORY_DETAILS;
--DROP TABLE VRMS_AGENT_CUSTOMER_DETAILS;
--DROP TABLE VRMS_USER_DETAILS;
--DROP TABLE C4_USER_DETAILS;
--DROP TABLE C4_ROLE_DETAILS;
--DROP TABLE C4_USER_SECURITY;
--DROP TABLE C4_COMPANY_DETAILS;


INSERT INTO C4_COMPANY_DETAILS (
COMPANY_OID, COMPANY_ID, COMPANY_NAME, PHONE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE
) VALUES (
'FFFFFFFFFFFFFFFF', 'C4CLOUD', 'C4 TECHNOLOGY SOLUTIONS','9849613769', 'AAAAAAAAAAAAAAAA',SYSDATE,'AAAAAAAAAAAAAAAA',SYSDATE
);

INSERT INTO C4_USER_SECURITY (USER_OID,USERNAME,PASSWORD,STATUS,CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, VERSION
) VALUES (
'AAAAAAAAAAAAAAAA', 'upender0209@gmail.com', 'chinni', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 1
);

INSERT INTO C4_ROLE_DETAILS (ROLE_ID, ROLE_NAME, COMPANY_OID
) VALUES (
'RL1000', 'STANDARD_AGENT', 'FFFFFFFFFFFFFFFF'
);
INSERT INTO C4_ROLE_DETAILS (ROLE_ID, ROLE_NAME, COMPANY_OID
) VALUES (
'RL1100', 'STANDARD_CUSTOMER', 'FFFFFFFFFFFFFFFF'
);

INSERT INTO C4_USER_DETAILS (
C4_USER_OID, USERNAME, EMAIL, FIRST_NAME, LAST_NAME, MOBILE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, ROLE_ID, COMPANY_OID
) VALUES (
'AAAAAAAAAAAAAAAA', 'upender0209@gmail', 'upender0209@gmail', 'Upender', 'Mamindlapelly', '9849613769', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'RL1000', 'FFFFFFFFFFFFFFFF'
);

INSERT INTO VRMS_USER_DETAILS (
C4_USER_OID, USERNAME, EMAIL, FIRST_NAME, LAST_NAME, MOBILE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, ROLE_ID, COMPANY_OID
) VALUES (
'AAAAAAAAAAAAAAAA', 'upender0209@gmail', 'upender0209@gmail', 'Upender', 'Mamindlapelly', '9849613769', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'RL1000', 'FFFFFFFFFFFFFFFF'
);

INSERT INTO VRMS_AGENT_CUSTOMER_DETAILS (
AG_CUST_OID, AG_CUST_ID, FIRST_NAME, LAST_NAME, MOBILE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, ROLE_ID, COMPANY_OID
) VALUES (
'BBBBBBBBBBBBBBBB', 'CUST2000', 'Bipin', 'Tiwari', '9542713769', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'RL1100', 'FFFFFFFFFFFFFFFF'
);

INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT100', '2024 TELUGU MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);
INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT101', '2023 HINDI MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);
INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT102', '2024 ENGLISH MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);
INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT103', '2024 TAMIL MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);
INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT104', '2023 TELUGU MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);
INSERT INTO VRMS_CATEGORY_DETAILS (
CATEGORY_ID, CATEGORY_NAME, ACTIVE_PRICE, INITIAL_PRICE, STATUS, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, COMPANY_OID
) VALUES (
'CAT105', '2023 MALAYALAM MOVIES', '50', '50', 'ACTIVE', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'FFFFFFFFFFFFFFFF'
);

INSERT INTO VRMS_MOVIE_DETAILS (
MOVIE_ID, MOVIE_NAME, CATEGORY_ID, COMPANY_OID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, STATUS, TOTAL_COPIES, AVAILABLE_COPIES
) VALUES (
'MV5000', 'SEETHA RAMAM', 'CAT104', 'FFFFFFFFFFFFFFFF', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'ACTIVE',5,5
);
INSERT INTO VRMS_MOVIE_DETAILS (
MOVIE_ID, MOVIE_NAME, CATEGORY_ID, COMPANY_OID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, STATUS, TOTAL_COPIES, AVAILABLE_COPIES
) VALUES (
'MV5001', 'RRR', 'CAT104', 'FFFFFFFFFFFFFFFF', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'ACTIVE',5,5
);
INSERT INTO VRMS_MOVIE_DETAILS (
MOVIE_ID, MOVIE_NAME, CATEGORY_ID, COMPANY_OID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, STATUS, TOTAL_COPIES, AVAILABLE_COPIES
) VALUES (
'MV5002', 'BRAHMASTRA', 'CAT101', 'FFFFFFFFFFFFFFFF', 'AAAAAAAAAAAAAAAA', SYSDATE, 'AAAAAAAAAAAAAAAA', SYSDATE, 'ACTIVE',5,5
);

COMMIT;