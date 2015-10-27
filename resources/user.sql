 use Sqs_test
 create table user{
 userId int not null,
 userName varchar(40) not null,
 passWd varchar(40) not null,
 phone bigint not null,
 mail varchar(40) not null,
 sex bit not null,
 summary varchar(100) ,
 address varchar(100),
 createtime date,
 primary key(userId) AUTO_INCREMENT
 };
 
 
 
 