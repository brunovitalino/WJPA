CREATE DATABASE wjpa;
USE wjpa;

CREATE TABLE Visitante
(
	id INT(6) UNSIGNED ZEROFILL AUTO_INCREMENT,
    nome VARCHAR(25) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(50),
    mensagem VARCHAR(500),
    PRIMARY KEY (id)
);

INSERT INTO Visitante(nome, telefone, email) VALUES ('Bruno Vitalino', '99998888', 'brunovitalino@hotmail.com');
INSERT INTO Visitante(nome, telefone, email) VALUES ('Sandra Regina', '99997777', '');
INSERT INTO Visitante(nome, telefone, email) VALUES ('Breno Oliveira', '99996666', '');

SELECT * FROM Visitante;

DROP TABLE Visitante;

DELETE FROM Visitante WHERE id>0;

SELECT * FROM Contatos;