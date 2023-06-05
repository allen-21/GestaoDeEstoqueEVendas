Create Database SistemaDeVenda;
use SistemaDeVenda;

CREATE TABLE `Usuario` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    
    `apelido` VARCHAR(50) NOT NULL , 

    `usuario` VARCHAR(50) NOT NULL , 
    `senha` VARCHAR(50) NOT NULL , 
    PRIMARY KEY (`id`));

CREATE TABLE `Administrador` (
    `id` INT NOT NULL AUTO_INCREMENT ,

    `apelido` VARCHAR(50) NOT NULL , 
 
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
id int(10) NOT NULL AUTO_INCREMENT,
data TIMESTAMP,
qtdItens int(10),
subtotal decimal(8,2),
pagamentoDinheiro decimal(8,2),
pagamentoCartao decimal(8,2),
user varchar(50)

);    

CREATE TABLE itemVenda (
idVenda int(10),
idItem int(10),
nomeProduto VARCHAR(50),
idProduto int(10),
qtdItens int(10),
valorTotal decimal(8,2),
valor decimal(8,2)
PRIMARY KEY (idVenda,idItem),
CONSTRAINT `itemVenda_ibfk_1` FOREIGN KEY (`idVenda`) REFERENCES `vendas` (`id`);

);

INSERT INTO `Administrador`(`id`, `nome`, `apelido`, `morada`, `usuario`, `senha`, `telefone`) VALUES (NULL, 'Admin', 'anibal', 'gfhg', 'allhgn', 'Admin', 'Admin');
INSERT INTO `Usuario`  (`id`, `nome`, `apelido`, `morada`, `usuario`, `senha`, `telefone`) VALUES (NULL, 'user', 'allen', 'asas', 'user', 'user', 'user');

