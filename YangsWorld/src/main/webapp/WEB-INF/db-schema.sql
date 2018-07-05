CREATE TABLE IF NOT EXISTS test
( 
IDX INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL, 
NAME VARCHAR(250) NOT NULL, 
CONTENT CLOB, 
PRIMARY KEY (IDX) 
);