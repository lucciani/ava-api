insert into estado (id, nome, uf) values (1, 'Minas Gerais', MG);
insert into estado (id, nome, uf) values (2, 'São Paulo', SP);
insert into estado (id, nome, uf) values (3, 'Ceará', CE);

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into categoria_administrativa (id, descricao, dt_inclusao, dt_atualizacao) values (1, 'Pública', utc_timestamp, utc_timestamp);
insert into categoria_administrativa (id, descricao, dt_inclusao, dt_atualizacao) values (2, 'Privada', utc_timestamp, utc_timestamp);

insert into situacao_escola (id, descricao, dt_inclusao, dt_atualizacao) values (1, 'Ativa', utc_timestamp, utc_timestamp);
insert into situacao_escola (id, descricao, dt_inclusao, dt_atualizacao) values (2, 'Paralisada', utc_timestamp, utc_timestamp);
