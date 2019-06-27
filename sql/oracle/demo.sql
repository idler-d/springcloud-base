CREATE TABLE USERS (
  "ID" VARCHAR2(36) NOT NULL ,
  "ACCOUNT" VARCHAR2(64) ,
  "PASSWORD" VARCHAR2(48) ,
  "SALT" VARCHAR2(16) ,
  "NAME" VARCHAR2(32) ,
  "AGE" NUMBER(3) ,
  "CREATE_TIME" DATE ,
  PRIMARY KEY ("ID")
);