
CREATE DATABASE spring;

CREATE TABLE product(
	Id int primary key auto_increment,
    NameP varChar(255) NOT NULL,
    DescriptionP varChar(255) NOT NULL,
    Price Double NOT NULL,
    Quantity int NOT NULL
);
CREATE TABLE Cliente(
	Id BigInt primary key auto_increment,
    Nome varChar(255) NOT NULL,
    Sobrenome varChar(255) NOT NULL,
    IdEndereco BigInt,
    foreign key(IdEndereco) references Endereco(Id)
);
CREATE TABLE Endereco(
	Id BigInt primary key auto_increment,
    Logradouro varChar(255) NOT NULL,
    Cidade varChar(255) NOT NULL,
    Estado varChar(255) NOT NULL
);

SELECT * FROM Product WHERE price < 500;
SELECT NameP, DescriptionP, Price FROM Product;