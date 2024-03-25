create database test_db;
use test_db;

create table test (
    id int primary key,
    name varchar(255)
);

insert into test values (1, 'foo');
insert into test values (2, 'bar');