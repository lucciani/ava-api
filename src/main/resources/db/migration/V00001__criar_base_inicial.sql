CREATE TABLE categoria_administrativa (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL,  
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE pais (
	id bigint NOT NULL, 
	sigla varchar(50) NOT NULL, 
	nome varchar(100) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE regiao (
	id bigint NOT NULL auto_increment, 
	sigla varchar(50) NOT NULL, 
	nome varchar(100) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE estado (
	id bigint NOT NULL, 
	sigla varchar(50) NOT NULL, 
	nome varchar(100) NOT NULL, 
	regiao_id bigint, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE cidade (
	id bigint NOT NULL auto_increment, 
	nome varchar(100) NOT NULL, 
	codigo_ibge bigint,
	estado_id bigint NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE crede (
	id bigint NOT NULL auto_increment, 
	sigla varchar(50), 
	descricao varchar(255), 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE empresa (
	id bigint NOT NULL auto_increment, 
	cnpj varchar(50) NOT NULL, 
	razao_social varchar(255) NOT NULL,
	dt_inclusao datetime(0) NOT NULL, 
	dt_atualizacao datetime(0) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb3;

CREATE TABLE escolaridade (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE ocupacao (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE localizacao (
	id bigint NOT NULL auto_increment, 
	descricao varchar(50) NOT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE situacao_escola (
	id bigint NOT NULL auto_increment, 
	descricao varchar(50) NOT NULL,
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE tipo_aluno (
	id bigint NOT NULL auto_increment, 
	descricao varchar(50) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE tipo_documento (
	id bigint NOT NULL auto_increment, 
	descricao varchar(50) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE catalogo_escola (
	id bigint NOT NULL auto_increment, 
	nome varchar(255) NOT NULL, 
	categoria_administrativa_id bigint, 	
	endereco_bairro varchar(100), 
	endereco_cep varchar(50), 
	endereco_complemento varchar(100), 
	endereco_logradouro varchar(255), 
	endereco_numero varchar(50), 
	localizacao_id bigint,
	endereco_cidade_id bigint, 
	endereco_pais_id bigint,	 
	situacao_escola bigint, 
	codigo_escola bigint, 
	crede_id bigint, 
	dt_inclusao datetime(0) NOT NULL,
	dt_atualizacao datetime(0) NOT NULL, 
	
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb3;

CREATE TABLE aluno (
	documento varchar(100), 
	tipo_documento_id bigint NOT NULL, 
	tipo_aluno_id bigint NOT NULL,
	nome varchar(255) NOT NULL, 
	nome_social varchar(255), 
	dt_nascimento date NOT NULL, 
	genero varchar(50), 
	sexo varchar(50) NOT NULL,
	celular varchar(50) NOT NULL, 
	email varchar(100) NOT NULL, 
	outro_telefone varchar(50), 
	telefone varchar(50), 
	whatsapp varchar(50),
	escolaridade_id bigint NOT NULL, 
	ocupacao_id bigint NOT NULL, 
	foto varchar(255), 
	senha varchar(255) NOT NULL, 
	endereco_bairro varchar(100), 
	endereco_cep varchar(50), 
	endereco_complemento varchar(100), 
	endereco_logradouro varchar(255), 
	endereco_numero varchar(50), 
	localizacao_id bigint,
	endereco_cidade_id bigint, 	
	endereco_pais_id bigint,
	escola_id bigint, 
	empresa_id bigint, 	
	dt_inclusao datetime(0) NOT NULL,
	dt_atualizacao datetime(0) NOT NULL, 
	
  PRIMARY KEY (documento, tipo_aluno_id, tipo_documento_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

alter table aluno add constraint fk_aluno_catalago_escola foreign key (escola_id) references catalogo_escola (id);
alter table aluno add constraint fk_aluno_empresa foreign key (empresa_id) references empresa (id);
alter table aluno add constraint fk_aluno_cidade foreign key (endereco_cidade_id) references cidade (id);
alter table aluno add constraint fk_aluno_pais foreign key (endereco_pais_id) references pais (id);
alter table aluno add constraint fk_aluno_escolaridade foreign key (escolaridade_id) references escolaridade (id);
alter table aluno add constraint fk_aluno_ocupacao foreign key (ocupacao_id) references ocupacao (id);
alter table aluno add constraint fk_aluno_tipo_aluno foreign key (tipo_aluno_id) references tipo_aluno (id);
alter table aluno add constraint fk_aluno_tipo_documento foreign key (tipo_documento_id) references tipo_documento (id);
alter table aluno add constraint fk_aluno_localizacao foreign key (localizacao_id) references localizacao (id);
alter table catalogo_escola add constraint fk_catalogo_escola_categoria_administrativa foreign key (categoria_administrativa_id) references categoria_administrativa (id);
alter table catalogo_escola add constraint fk_catalogo_escola_crede foreign key (crede_id) references crede (id);
alter table catalogo_escola add constraint fk_catalogo_escola_cidade foreign key (endereco_cidade_id) references cidade (id);
alter table catalogo_escola add constraint fk_catalogo_escola_situacao_escola foreign key (situacao_escola) references situacao_escola (id);
alter table catalogo_escola add constraint fk_catalogo_escola_localizacao foreign key (localizacao_id) references localizacao (id);
alter table cidade add constraint fk_cidade_estado foreign key (estado_id) references estado (id);
alter table estado add constraint fk_estado_regiao foreign key (regiao_id) references regiao (id);

