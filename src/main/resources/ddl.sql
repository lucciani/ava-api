create table aluno (documento varchar(255) not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, tipo_aluno_id bigint not null, primary key (documento, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, tipo_aluno_id bigint not null, primary key (documento, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, tipo_aluno_id bigint not null, primary key (documento, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_aluno_id bigint not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, primary key (documento, tipo_aluno_id, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_aluno_id bigint not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, primary key (documento, tipo_aluno_id, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_aluno_id bigint not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, primary key (documento, tipo_aluno_id, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_aluno_id bigint not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, primary key (documento, tipo_aluno_id, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint UK_e2195vohhcajdyj0orotn90lv unique (tipo_documento_id)
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
create table aluno (documento varchar(255) not null, tipo_aluno_id bigint not null, tipo_documento_id bigint not null, celular varchar(255) not null, email varchar(255) not null, outro_telefone varchar(255), telefone varchar(255), whatsapp varchar(255), dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), foto varchar(255), dt_nascimento date not null, genero varchar(255), nome varchar(255) not null, nome_social varchar(255), senha varchar(255) not null, sexo varchar(255) not null, escola_id bigint not null, empresa_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, escolaridade_id bigint not null, ocupacao_id bigint not null, primary key (documento, tipo_aluno_id, tipo_documento_id)) engine=InnoDB
create table catalogo_escola (id bigint not null auto_increment, codigo_escola bigint, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, categoria_administrativa_id bigint, crede_id bigint, endereco_cidade_id bigint, endereco_pais_id bigint, situacao_escola bigint, primary key (id)) engine=InnoDB
create table categoria_administrativa (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table cidade (id bigint not null auto_increment, codigo_ibge bigint, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table crede (id bigint not null auto_increment, descricao varchar(255), sigla varchar(255), primary key (id)) engine=InnoDB
create table empresa (id bigint not null auto_increment, cnpj varchar(255) not null, dt_atualizacao datetime(0) not null, dt_inclusao datetime(0) not null, razao_social varchar(255) not null, primary key (id)) engine=InnoDB
create table escolaridade (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, regiao_id bigint not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
create table ocupacao (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table pais (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table regiao (id bigint not null auto_increment, nome varchar(255) not null, sigla varchar(255) not null, primary key (id)) engine=InnoDB
create table situacao_escola (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_aluno (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table tipo_documento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
alter table aluno add constraint FK1sfcvufawdhq3qa07khklbgfh foreign key (escola_id) references catalogo_escola (id)
alter table aluno add constraint FKss8t41eg1l7hkq9rub07tjudh foreign key (empresa_id) references empresa (id)
alter table aluno add constraint FK3y264i7k33fw00903fu4v4lav foreign key (endereco_cidade_id) references cidade (id)
alter table aluno add constraint FKnt9xivk199mfm5abi6jkgdkct foreign key (endereco_pais_id) references pais (id)
alter table aluno add constraint FKdu60iqye3ymxxd7981lt2og6f foreign key (escolaridade_id) references escolaridade (id)
alter table aluno add constraint FKajhrhhw18jmb23eirkuf8pk6h foreign key (ocupacao_id) references ocupacao (id)
alter table aluno add constraint FKm3xnlqk93c0wjl1ra7uu5haun foreign key (tipo_aluno_id) references tipo_aluno (id)
alter table aluno add constraint FK4or2gxlhhkhmvsx5g47n32vey foreign key (tipo_documento_id) references tipo_documento (id)
alter table catalogo_escola add constraint FKh3strh8ruvda2pnjpcp7fi1ex foreign key (categoria_administrativa_id) references categoria_administrativa (id)
alter table catalogo_escola add constraint FKro9f6pi2m49kboj84of6ueyuh foreign key (crede_id) references crede (id)
alter table catalogo_escola add constraint FKoxqxx5keeo7km43f6vqdny4vp foreign key (endereco_cidade_id) references cidade (id)
alter table catalogo_escola add constraint FK93h3f3j99q15luscnlppsba7v foreign key (endereco_pais_id) references pais (id)
alter table catalogo_escola add constraint FKme15o4klugv9fm299memcackk foreign key (situacao_escola) references situacao_escola (id)
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table estado add constraint FKqimccebl0rlmu946bdnh443c5 foreign key (regiao_id) references regiao (id)
