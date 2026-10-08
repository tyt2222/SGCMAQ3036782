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
    primary key (id),
    foreign key (tipo_usuario_id) references tipo_usuario(id)
);

-- Inserindo um perfil/tipo de usuário padrão (Administrador) para evitar erro de chave estrangeira
INSERT INTO tipo_usuario (id, modulo_administrativo, modulo_agendamento, modulo_atendimento) 
VALUES (1, 'S', 'S', 'S');

