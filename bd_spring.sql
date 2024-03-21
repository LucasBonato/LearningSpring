
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
CREATE TABLE 
-- Alterando o Nome do Campo por conta de conflito com o Spring
ALTER TABLE Cliente RENAME COLUMN IdEndereco TO Id_Endereco;

-- Trocando as Tabelas de OneToOne(1,1), para OneToMany(1,n)
ALTER TABLE Endereco ADD COLUMN Id_Cliente BigInt,
ADD CONSTRAINT fk_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id);
-- Trazendo os dados anteriores para não haver perda no Banco
UPDATE Endereco SET Id_Cliente = (SELECT Id FROM Cliente WHERE Id = Endereco.Id);
-- Apagando a FK de Cliente
ALTER TABLE Cliente DROP FOREIGN KEY cliente_ibfk_1;
ALTER TABLE Cliente DROP COLUMN Id_Endereco;

-- Inserção de Dados nas Tabelas OneToOne
INSERT INTO Endereco(Logradouro, Cidade, Estado)VALUE('Rua Banofe Louco, 256', 'São Paulo', 'São Paulo');
INSERT INTO Cliente(Nome, Sobrenome, Id_Endereco)VALUE('Diogo', 'Breviglieri', 1);

-- Inserção de Dados nas tabelas OneToMany
INSERT INTO Cliente(Nome, Sobrenome)VALUE('Luiz', 'Oliveira');
INSERT INTO Endereco(Logradouro, Cidade, Estado, Id_Cliente)VALUE
('Rua dos Loucos Autonomos, 26', 'São Paulo', 'São Paulo', 1),
('Avenida Grajas, 12', 'Grajaú', 'Rio de Janeiro', 2);

SELECT * FROM Cliente c INNER JOIN Endereco e ON c.Id = e.Id_Cliente;
SELECT * FROM Endereco;
SELECT * FROM Cliente;
SELECT * FROM Product WHERE price < 500;
SELECT NameP, DescriptionP, Price FROM Product;