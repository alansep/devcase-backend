/*CRIAÇÃO DO BANCO*/
CREATE DATABASE vsmdevcasedb;

/*CRIAÇÃO DA TABELA DE CLIENTES*/
CREATE TABLE CLIENTE(
cli_codigo integer primary key auto_increment,
cli_pontuacao integer not null,
cli_nome varchar(100) not null,
cli_idade integer not null,
cli_sexo varchar(1) not null,
cli_email varchar(60) not null,
cli_telefone varchar(20) not null,
cli_rua varchar(100) not null,
cli_bairro varchar(80) not null,
cli_numero varchar(5) not null,
cli_complemento varchar(5),
cli_cidade varchar(50) not null,
cli_estado varchar(2) not null);

/*CRIAÇÃO DA TABELA DE REGRAS*/
CREATE TABLE REGRA(
reg_codigo integer primary key auto_increment,
reg_valor_max integer not null,
reg_valor_min integer not null
);




