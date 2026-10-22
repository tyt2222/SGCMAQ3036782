drop database if exists SGCMAQ3036782;
create database SGCMAQ3036782;
use SGCMAQ3036782;

create table tipo_usuario (
id int not null,
modulo_administrativo varchar(1) not null,
modulo_agendamento varchar(1) not null,
modulo_atendimento varchar(1) not null,
primary key (id)
);

create table usuario (
id int not null,
nome varchar(50),
senha varchar(100) not null,
tipo_usuario_id int not null,
nascimento date,
logradouro varchar(100),
numero varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(50),
uf varchar(2),
cep varchar(10),
primary key (id),
foreign key (tipo_usuario_id) references tipo_usuario(id)
);

describe usuario;
select * from usuario;
select * from tipo_usuario;

INSERT INTO tipo_usuario (id, modulo_administrativo, modulo_agendamento, modulo_atendimento)
VALUES (1, 'S', 'S', 'S');

INSERT INTO usuario (id, nome, senha, tipo_usuario_id)
VALUES (
1,
'admin',
SHA2(CONCAT(1, 'admin'), 256),
1
);

