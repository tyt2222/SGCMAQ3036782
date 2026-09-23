create database sgcm_prof;
use sgcm_prof;

create table usuario (
    id int not null,
    nome varchar(50),
    senha varchar(100) not null,
    primary key (id)
);
