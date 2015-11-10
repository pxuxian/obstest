 drop database if exists Sqs_test;
 create database Sqs_test;
 use Sqs_test;
 
 drop table if exists t_user
  create table t_user(
 userId int not null primary key  AUTO_INCREMENT,
 userName varchar(40) not null ,
 passWd varchar(40) not null,
 phone varchar(20) not null,
 mail varchar(40) not null,
 sex int not null,
 summary varchar(100),
 address varchar(100),
 createtime date
 );
 
 
 
 