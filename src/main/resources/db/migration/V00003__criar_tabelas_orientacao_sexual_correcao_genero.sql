CREATE TABLE orientacao_sexual (
	id bigint NOT NULL auto_increment, 
	descricao varchar(100) NOT NULL,  
	
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

ALTER TABLE aluno ADD COLUMN orientacao_sexual_id bigint NULL AFTER genero_id;

alter table aluno add constraint fk_aluno_orientacao_sexual foreign key (orientacao_sexual_id) references orientacao_sexual (id);

