CREATE TABLE sexo (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL,  
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE genero (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL,  
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

ALTER TABLE aluno CHANGE COLUMN genero genero_id bigint AFTER dt_nascimento;
ALTER TABLE aluno CHANGE COLUMN sexo sexo_id bigint AFTER genero_id;

alter table aluno add constraint fk_aluno_sexo foreign key (sexo_id) references sexo (id);
alter table aluno add constraint fk_aluno_genero foreign key (genero_id) references genero (id);

