CREATE TABLE endereco (
	id bigint NOT NULL auto_increment, 
	endereco_cep varchar(15) NOT NULL, 
	endereco_bairro varchar(255) NOT NULL, 
	endereco_logradouro varchar(255) NOT NULL, 
	endereco_cidade_id bigint NOT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

ALTER TABLE endereco add constraint fk_endereco_cidade foreign key (endereco_cidade_id) references cidade (id);

ALTER TABLE aluno DROP CONSTRAINT fk_aluno_cidade;
ALTER TABLE aluno DROP COLUMN endereco_bairro, DROP COLUMN endereco_cep, DROP COLUMN endereco_logradouro, DROP COLUMN endereco_cidade_id;
ALTER TABLE aluno ADD COLUMN endereco_id bigint NULL AFTER senha;
ALTER TABLE aluno add constraint fk_aluno_endereco_id foreign key (endereco_id) references endereco (id);

ALTER TABLE catalogo_escola DROP CONSTRAINT fk_catalogo_escola_cidade;
ALTER TABLE catalogo_escola DROP COLUMN endereco_bairro, DROP COLUMN endereco_cep, DROP COLUMN endereco_logradouro, DROP COLUMN endereco_cidade_id;
ALTER TABLE catalogo_escola ADD COLUMN endereco_id bigint NULL AFTER categoria_administrativa_id;
ALTER TABLE catalogo_escola add constraint fk_catalogo_escola_endereco_id foreign key (endereco_id) references endereco (id);


