CREATE DATABASE bd_apicontatos;
USE bd_apicontatos;

CREATE TABLE contato(
id             INTEGER           AUTO_INCREMENT      
nome           VARCHAR(50)       NOT NULL,
email          VARCHAR(50)       NOT NULL,
telefone       VARCHAR(50)       NOT NULL,
PRIMARY KEY(id)
);

SELECT * FROM contato;