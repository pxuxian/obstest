 drop database if exists Sqs_test;
 create database Sqs_test;
 use Sqs_test;
 
 drop table if exists user;
 create table user(
	 userId int primary key(userId) AUTO_INCREMENT,
	 userName varchar(40) not null,
	 passWd varchar(40) not null,
	 phone bigint not null,
	 mail varchar(40) not null,
	 sex bit not null,
	 summary varchar(100) ,
	 address varchar(100),
	 createtime date,
 );
 
 
 
 