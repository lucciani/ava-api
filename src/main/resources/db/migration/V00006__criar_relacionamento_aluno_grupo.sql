create table aluno_grupo (
	tipo_documento_id bigint not null,
	tipo_aluno_id bigint not null,
	documento varchar(50) not null,
	grupo_id bigint not null,
	
	primary key (tipo_documento_id,tipo_aluno_id,documento, grupo_id)
) engine=InnoDB default charset=utf8;

alter table aluno_grupo add constraint fk_aluno_grupo_grupo
foreign key (grupo_id) references grupo (id);

alter table aluno_grupo add constraint fk_aluno_grupo_tipo_aluno 
foreign key (tipo_aluno_id) references tipo_aluno (id);

alter table aluno_grupo add constraint fk_aluno_grupo_tipo_documento 
foreign key (tipo_documento_id) references tipo_documento (id);


