CREATE DATABASE IF NOT EXISTS academia;
USE academia;

CREATE TABLE IF NOT EXISTS usuario (
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(100) NOT NULL UNIQUE,
	nome VARCHAR(100) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	data_cadastro DATE NOT NULL,
	cpf CHAR(11) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS enderecos (
	id_end INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL,
	rua VARCHAR(100),
	numero VARCHAR(10),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	estado CHAR(2) CHECK (estado REGEXP '^[A-Z]{2}$'),
	cep CHAR(8),
	FOREIGN KEY (id_usuario) REFERENCES usuario(user_id)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS plano (
	id_plano INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL UNIQUE,
	preco DECIMAL(10,2) NOT NULL,
	duracao_meses INT NOT NULL,
	descricao TEXT
);

CREATE TABLE IF NOT EXISTS aluno (
	id_aluno INT AUTO_INCREMENT PRIMARY KEY,
	id_usuario INT NOT NULL UNIQUE,
	data_inicio DATE NOT NULL,
	id_plano INT,
	FOREIGN KEY (id_usuario) REFERENCES usuario(user_id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_plano) REFERENCES plano(id_plano)
);

CREATE TABLE IF NOT EXISTS instrutor (
	id_usuario INT NOT NULL PRIMARY KEY,
	registro_cref VARCHAR(20),
	horario VARCHAR(50),
	especialidade VARCHAR(100),
	FOREIGN KEY (id_usuario) REFERENCES usuario(user_id)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS pagamentos (
	id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
	id_aluno INT NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	data_pagamento DATE NOT NULL,
	metodo_pagamento VARCHAR(50) CHECK (metodo_pagamento IN ('PIX', 'Cartão Crédito', 'Cartão Débito', 'Dinheiro')),
	status VARCHAR(20) CHECK (status IN ('PAGO', 'PENDENTE', 'ATRASADO')),
	FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS treino (
	id_treino INT AUTO_INCREMENT PRIMARY KEY,
	id_aluno INT NOT NULL,
	id_instrutor INT,
	data_treino DATE,
	tipo_treino VARCHAR(100),
	observacoes TEXT,
	FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_instrutor) REFERENCES instrutor(id_usuario)
		ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS presenca (
	id_presenca INT AUTO_INCREMENT PRIMARY KEY,
	id_aluno INT NOT NULL,
	data DATE NOT NULL,
	hora_entrada TIME,
	hora_saida TIME,
	FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
		ON DELETE CASCADE ON UPDATE CASCADE
);
