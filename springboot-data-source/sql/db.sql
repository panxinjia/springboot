create database spring_boot_datasource;


create table t_user(
    id int primary key auto_increment,
    name varchar(20) default "" not null ,
    age int not null
);

insert into t_user(name, age) values
    ('node100-tom', 10),
    ('node100-jerry', 10);

select * from t_user;