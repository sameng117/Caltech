CREATE DATABASE IF NOT EXISTS hibernatelog4j;

USE hibernatelog4j;

DROP TABLE IF EXISTS emp_table;

CREATE TABLE emp_table (
  emp_id int(20) NOT NULL,
  emp_name varchar(255) NULL,
  emp_sal int (150) NOT NULL,  
  PRIMARY KEY (emp_id)
);