
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

ALTER TABLE Cliente RENAME COLUMN IdEndereco TO Id_Endereco;

INSERT INTO Endereco(Logradouro, Cidade, Estado)VALUE('Rua Banofe Louco, 256', 'São Paulo', 'São Paulo');
INSERT INTO Cliente(Nome, Sobrenome, IdEndereco)VALUE('Diogo', 'Breviglieri', 1);

SELECT * FROM Cliente c INNER JOIN Endereco e ON c.Id_Endereco = e.Id;

select 
	c.id,
	c.nome,
	c.sobrenome,
	e.id,
	e.cidade,
	e.estado,
	e.logradouro
from cliente c
left join endereco e
on e.id = c.id_Endereco 
where c.id = 1;

SELECT * FROM Product WHERE price < 500;
SELECT NameP, DescriptionP, Price FROM Product;