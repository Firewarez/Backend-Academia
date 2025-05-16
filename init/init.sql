CREATE DATABASE IF NOT EXISTS academia;
USE academia;

CREATE TABLE `usuario` (
	`user_id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	`nome` VARCHAR(100) NOT NULL,
	`senha` VARCHAR(255) NOT NULL,
	`data_cadastro` DATE NOT NULL,
	`cpf` CHAR(11) NOT NULL UNIQUE,
	PRIMARY KEY(`user_id`)
);


CREATE TABLE `endereços` (
	`id_end` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`id_usuario` INTEGER NOT NULL,
	`rua` VARCHAR(100),
	`numero` VARCHAR(10),
	`bairro` VARCHAR(50),
	`cidade` VARCHAR(50),
	`estado` VARCHAR(2),
	`cep` VARCHAR(8),
	PRIMARY KEY(`id_end`)
);


CREATE TABLE `pagamentos` (
	`id_pagamento` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`id_aluno` INTEGER NOT NULL,
	`valor` DECIMAL NOT NULL,
	`data_pagamento` DATE NOT NULL,
	`metodo_pagamento` VARCHAR(50),
	`status` VARCHAR(20),
	PRIMARY KEY(`id_pagamento`)
);


CREATE TABLE `instrutor` (
	`id_usuario` INTEGER NOT NULL UNIQUE,
	`registro_cref` VARCHAR(20),
	`horario` VARCHAR(50),
	`especialidade` VARCHAR(100),
	PRIMARY KEY(`id_usuario`)
);


CREATE TABLE `aluno` (
	`id_usuario` INTEGER NOT NULL UNIQUE,
	`id_aluno` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`data_inicio` DATE NOT NULL,
	`plano` VARCHAR(50),
	PRIMARY KEY(`id_aluno`)
);


ALTER TABLE `usuario`
ADD FOREIGN KEY(`user_id`) REFERENCES `instrutor`(`id_usuario`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `usuario`
ADD FOREIGN KEY(`user_id`) REFERENCES `aluno`(`id_usuario`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `endereços`
ADD FOREIGN KEY(`id_usuario`) REFERENCES `usuario`(`user_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `aluno`
ADD FOREIGN KEY(`id_aluno`) REFERENCES `pagamentos`(`id_aluno`)
ON UPDATE NO ACTION ON DELETE NO ACTION;