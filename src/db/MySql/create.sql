CREATE DATABASE ExcellentVoyage;

USE ExcellentVoyage;

CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`senha` varchar(255) NOT NULL,
	`tipo` ENUM('admin','cliente','agencia') NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cliente` (
	`cpf` varchar(255) NOT NULL UNIQUE,
	`telefone` varchar(255) NOT NULL,
	`sexo` ENUM('masculino','feminino') NOT NULL,
	`data_nascimento` TIMESTAMP NOT NULL,
	`id_usuario` INT NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `agencia` (
	`cnpj` varchar(255) NOT NULL UNIQUE,
	`descricao` varchar(255) NOT NULL,
	`id_usuario` INT NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `pacote_turistico` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`cnpj_agencia` varchar(255) NOT NULL,
	`destino_cidade` varchar(255) NOT NULL,
	`destino_estado` varchar(255) NOT NULL,
	`destino_pais` varchar(255) NOT NULL,
	`data_partida` TIMESTAMP NOT NULL,
	`duracao_dias` INT NOT NULL,
	`valor` FLOAT NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`qtd_foto` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `foto` (
	`id_pacote` INT NOT NULL,
	`url` varchar(255) NOT NULL
);

CREATE TABLE `compra` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_cliente` INT NOT NULL,
	`id_pacote` INT NOT NULL,
	`data_reuniao` TIMESTAMP NOT NULL,
	`link_reuniao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `cliente` ADD CONSTRAINT `cliente_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id`);

ALTER TABLE `agencia` ADD CONSTRAINT `agencia_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id`);

ALTER TABLE `pacote_turistico` ADD CONSTRAINT `pacote_turistico_fk0` FOREIGN KEY (`cnpj_agencia`) REFERENCES `agencia`(`cnpj`);

ALTER TABLE `foto` ADD CONSTRAINT `foto_fk0` FOREIGN KEY (`id_pacote`) REFERENCES `pacote_turistico`(`id`);

ALTER TABLE `compra` ADD CONSTRAINT `compra_fk0` FOREIGN KEY (`id_cliente`) REFERENCES `cliente`(`id_usuario`);

ALTER TABLE `compra` ADD CONSTRAINT `compra_fk1` FOREIGN KEY (`id_pacote`) REFERENCES `pacote_turistico`(`id`);
