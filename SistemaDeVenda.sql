Create Database SistemaDeVenda;
use SistemaDeVenda;

CREATE TABLE `Usuario` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `nome` VARCHAR(50) NOT NULL , 
    `apelido` VARCHAR(50) NOT NULL , 
    `morada` VARCHAR(50) NOT NULL , 
    `usuario` VARCHAR(50) NOT NULL , 
    `senha` VARCHAR(50) NOT NULL , 
    PRIMARY KEY (`id`));

CREATE TABLE `Administrador` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `nome` VARCHAR(50) NOT NULL , 
    `apelido` VARCHAR(50) NOT NULL , 
    `morada` VARCHAR(50) NOT NULL , 
    `usuario` VARCHAR(50) NOT NULL , 
    `senha` VARCHAR(50) NOT NULL , 
    PRIMARY KEY (`id`));


CREATE TABLE produto (
 id int(10) not null auto_increment,
nome varchar(50),
categoria varchar(30),
quantidade int(3),
custo decimal(8,2),
valor decimal(8,2),
descricao varchar(1000),
primary key (id)
);

CREATE TABLE vendas(
id int(10) not null auto_increment,
data TIMESTAMP,
qtdItens int(10),
subtotal decimal(8,2),
pagamentoDinheiro decimal(8,2),
pagamentoCartao decimal(8,2),
user varchar(50),
primary key (id)

);    

CREATE TABLE itemVenda (
idVenda int(10) not null auto_increment,
idItem int(10),
nomeProduto VARCHAR(50),
idProduto int(10),
qtdItens int(10),
valorTotal decimal(8,2),
valor decimal(8,2),
primary key (idVenda)
);

