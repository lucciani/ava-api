set foreign_key_checks = 0;

delete from aluno;
delete from catalogo_escola;
delete from categoria_administrativa;
delete from cidade;
delete from crede;
delete from empresa;
delete from escolaridade;
delete from estado;
delete from localizacao;
delete from ocupacao;
delete from pais;
delete from regiao;
delete from situacao_escola;
delete from tipo_aluno;
delete from tipo_documento;

set foreign_key_checks = 1;

alter table aluno auto_increment = 10000;
alter table catalogo_escola auto_increment = 10000;
alter table categoria_administrativa auto_increment = 1;
alter table cidade auto_increment = 1;
alter table crede auto_increment = 1;
alter table empresa auto_increment = 1;
alter table escolaridade auto_increment = 1;
alter table localizacao auto_increment = 1;
alter table ocupacao auto_increment = 1;
alter table regiao auto_increment = 1;
alter table situacao_escola auto_increment = 1;
alter table tipo_aluno auto_increment = 1;
alter table tipo_documento auto_increment = 1;

INSERT INTO regiao VALUES (1, 'N', 'Norte');
INSERT INTO regiao VALUES (2, 'NE', 'Nordeste');
INSERT INTO regiao VALUES (3, 'SE', 'Sudeste');
INSERT INTO regiao VALUES (4, 'S', 'Sul');
INSERT INTO regiao VALUES (5, 'CO', 'Centro-Oeste');

INSERT INTO tipo_aluno VALUES (1, 'Sistema');
INSERT INTO tipo_aluno VALUES (2, 'Pública');
INSERT INTO tipo_aluno VALUES (3, 'Privada');

INSERT INTO localizacao VALUES (1, 'Rural');
INSERT INTO localizacao VALUES (2, 'Urbana');

INSERT INTO tipo_documento VALUES (1, 'Cpf');
INSERT INTO tipo_documento VALUES (2, 'Matricula');
INSERT INTO tipo_documento VALUES (3, 'Passaporte');

INSERT INTO escolaridade VALUES (1, 'Ensino Fundamental Incompleto');
INSERT INTO escolaridade VALUES (2, 'Ensino Fundamental Completo');
INSERT INTO escolaridade VALUES (3, 'Ensino Medio Incompleto');
INSERT INTO escolaridade VALUES (4, 'Ensino Medio Completo');
INSERT INTO escolaridade VALUES (5, 'Ensino Superior Incompleto');
INSERT INTO escolaridade VALUES (6, 'Ensino Superior Completo');
INSERT INTO escolaridade VALUES (7, 'Pós-Graduação');
INSERT INTO escolaridade VALUES (8, 'Outros');

INSERT INTO ocupacao VALUES (1, 'Aposentado');
INSERT INTO ocupacao VALUES (2, 'Autônomo');
INSERT INTO ocupacao VALUES (3, 'Desempregado');
INSERT INTO ocupacao VALUES (4, 'Educador(a) Socio/Voluntário');
INSERT INTO ocupacao VALUES (5, 'Empresário');
INSERT INTO ocupacao VALUES (6, 'Estudante da Rede Particular');
INSERT INTO ocupacao VALUES (7, 'Estudante da Rede Pública');
INSERT INTO ocupacao VALUES (8, 'Funcionário Empresa Privada');
INSERT INTO ocupacao VALUES (9, 'Funcionário Empresa Pública');
INSERT INTO ocupacao VALUES (10, 'Militar');
INSERT INTO ocupacao VALUES (11, 'Professor(a) de Ensino Superior');
INSERT INTO ocupacao VALUES (12, 'Professor(a) de Escolas da Rede Particular');
INSERT INTO ocupacao VALUES (13, 'Professor(a) de Escolas da Rede Pública');
INSERT INTO ocupacao VALUES (14, 'Professor(a) de Escolas da Rede Pública e Particular');
INSERT INTO ocupacao VALUES (15, 'Serviço Público (Executivo)');
INSERT INTO ocupacao VALUES (16, 'Serviço Público (Judiciário)');
INSERT INTO ocupacao VALUES (17, 'Serviço Público (Legislativo)');
INSERT INTO ocupacao VALUES (18, 'Terceiro Setor (Fundações, Associações, ONGs, OSCs etc.)');
INSERT INTO ocupacao VALUES (19, 'Outros');

INSERT INTO categoria_administrativa (id, descricao) VALUES (1, 'Pública');
INSERT INTO categoria_administrativa (id, descricao) VALUES (2, 'Privada');

INSERT INTO situacao_escola (id, descricao) VALUES (1, 'Ativa');
INSERT INTO situacao_escola (id, descricao) VALUES (2, 'Paralisada');

INSERT INTO crede (id, sigla, descricao) VALUES (1, 'CREDE 1', 'Coordenadorias Regionais de Desenvolvimento da Educação 1');
INSERT INTO crede (id, sigla, descricao) VALUES (2, 'CREDE 2', 'Coordenadorias Regionais de Desenvolvimento da Educação 2');
INSERT INTO crede (id, sigla, descricao) VALUES (3, 'CREDE 3', 'Coordenadorias Regionais de Desenvolvimento da Educação 3');
INSERT INTO crede (id, sigla, descricao) VALUES (4, 'CREDE 4', 'Coordenadorias Regionais de Desenvolvimento da Educação 4');
INSERT INTO crede (id, sigla, descricao) VALUES (5, 'CREDE 5', 'Coordenadorias Regionais de Desenvolvimento da Educação 5');
INSERT INTO crede (id, sigla, descricao) VALUES (6, 'CREDE 6', 'Coordenadorias Regionais de Desenvolvimento da Educação 6');
INSERT INTO crede (id, sigla, descricao) VALUES (7, 'CREDE 7', 'Coordenadorias Regionais de Desenvolvimento da Educação 7');
INSERT INTO crede (id, sigla, descricao) VALUES (8, 'CREDE 8', 'Coordenadorias Regionais de Desenvolvimento da Educação 8');
INSERT INTO crede (id, sigla, descricao) VALUES (9, 'CREDE 9', 'Coordenadorias Regionais de Desenvolvimento da Educação 9');
INSERT INTO crede (id, sigla, descricao) VALUES (10, 'CREDE 10', 'Coordenadorias Regionais de Desenvolvimento da Educação 10');
INSERT INTO crede (id, sigla, descricao) VALUES (11, 'CREDE 11', 'Coordenadorias Regionais de Desenvolvimento da Educação 11');
INSERT INTO crede (id, sigla, descricao) VALUES (12, 'CREDE 12', 'Coordenadorias Regionais de Desenvolvimento da Educação 12');
INSERT INTO crede (id, sigla, descricao) VALUES (13, 'CREDE 13', 'Coordenadorias Regionais de Desenvolvimento da Educação 13');
INSERT INTO crede (id, sigla, descricao) VALUES (14, 'CREDE 14', 'Coordenadorias Regionais de Desenvolvimento da Educação 14');
INSERT INTO crede (id, sigla, descricao) VALUES (15, 'CREDE 15', 'Coordenadorias Regionais de Desenvolvimento da Educação 15');
INSERT INTO crede (id, sigla, descricao) VALUES (16, 'CREDE 16', 'Coordenadorias Regionais de Desenvolvimento da Educação 16');
INSERT INTO crede (id, sigla, descricao) VALUES (17, 'CREDE 17', 'Coordenadorias Regionais de Desenvolvimento da Educação 17');
INSERT INTO crede (id, sigla, descricao) VALUES (18, 'CREDE 18', 'Coordenadorias Regionais de Desenvolvimento da Educação 18');
INSERT INTO crede (id, sigla, descricao) VALUES (19, 'CREDE 19', 'Coordenadorias Regionais de Desenvolvimento da Educação 19');
INSERT INTO crede (id, sigla, descricao) VALUES (20, 'CREDE 20', 'Coordenadorias Regionais de Desenvolvimento da Educação 20');
INSERT INTO crede (id, sigla, descricao) VALUES (21, 'SEFOR 1', 'Superintendências das Escolas Estaduais de Fortaleza 1');
INSERT INTO crede (id, sigla, descricao) VALUES (22, 'SEFOR 2', 'Superintendências das Escolas Estaduais de Fortaleza 2');
INSERT INTO crede (id, sigla, descricao) VALUES (23, 'SEFOR 3', 'Superintendências das Escolas Estaduais de Fortaleza 3');

INSERT INTO pais VALUES (4, 'AF', 'Afeganistão');
INSERT INTO pais VALUES (8, 'AL', 'Albânia');
INSERT INTO pais VALUES (12, 'DZ', 'Argélia');
INSERT INTO pais VALUES (20, 'AD', 'Andorra');
INSERT INTO pais VALUES (24, 'AO', 'Angola');
INSERT INTO pais VALUES (28, 'AG', 'Antígua e Barbuda');
INSERT INTO pais VALUES (31, 'AZ', 'Azerbaijão');
INSERT INTO pais VALUES (32, 'AR', 'Argentina');
INSERT INTO pais VALUES (36, 'AU', 'Austrália');
INSERT INTO pais VALUES (40, 'AT', 'Áustria');
INSERT INTO pais VALUES (44, 'BS', 'Bahamas');
INSERT INTO pais VALUES (48, 'BH', 'Barein');
INSERT INTO pais VALUES (50, 'BD', 'Bangladesh');
INSERT INTO pais VALUES (51, 'AM', 'Armênia');
INSERT INTO pais VALUES (52, 'BB', 'Barbados');
INSERT INTO pais VALUES (56, 'BE', 'Bélgica');
INSERT INTO pais VALUES (64, 'BT', 'Butão');
INSERT INTO pais VALUES (68, 'BO', 'Bolívia');
INSERT INTO pais VALUES (70, 'BA', 'Bósnia e Herzegovina');
INSERT INTO pais VALUES (72, 'BW', 'Botsuana');
INSERT INTO pais VALUES (76, 'BR', 'Brasil');
INSERT INTO pais VALUES (84, 'BZ', 'Belize');
INSERT INTO pais VALUES (90, 'SB', 'Ilhas Salomão');
INSERT INTO pais VALUES (96, 'BN', 'Brunei');
INSERT INTO pais VALUES (100, 'BG', 'Bulgária');
INSERT INTO pais VALUES (104, 'MM', 'Mianmar');
INSERT INTO pais VALUES (108, 'BI', 'Burundi');
INSERT INTO pais VALUES (112, 'BY', 'Belarus');
INSERT INTO pais VALUES (116, 'KH', 'Camboja');
INSERT INTO pais VALUES (120, 'CM', 'Camarões');
INSERT INTO pais VALUES (124, 'CA', 'Canadá');
INSERT INTO pais VALUES (132, 'CV', 'Cabo Verde');
INSERT INTO pais VALUES (140, 'CF', 'República Centro Africana');
INSERT INTO pais VALUES (144, 'LK', 'Sri Lanka');
INSERT INTO pais VALUES (148, 'TD', 'Chade');
INSERT INTO pais VALUES (152, 'CL', 'Chile');
INSERT INTO pais VALUES (156, 'CN', 'China');
INSERT INTO pais VALUES (170, 'CO', 'Colômbia');
INSERT INTO pais VALUES (174, 'KM', 'Comores');
INSERT INTO pais VALUES (178, 'CG', 'Congo');
INSERT INTO pais VALUES (180, 'CD', 'República Democrática do Congo');
INSERT INTO pais VALUES (188, 'CR', 'Costa Rica');
INSERT INTO pais VALUES (191, 'HR', 'Croácia');
INSERT INTO pais VALUES (192, 'CU', 'Cuba');
INSERT INTO pais VALUES (196, 'CY', 'Chipre');
INSERT INTO pais VALUES (203, 'CZ', 'República Tcheca');
INSERT INTO pais VALUES (204, 'BJ', 'Benin');
INSERT INTO pais VALUES (208, 'DK', 'Dinamarca');
INSERT INTO pais VALUES (212, 'DM', 'Dominica');
INSERT INTO pais VALUES (214, 'DO', 'República Dominicana');
INSERT INTO pais VALUES (218, 'EC', 'Equador');
INSERT INTO pais VALUES (222, 'SV', 'El Salvador');
INSERT INTO pais VALUES (226, 'GQ', 'Guiné Equatorial');
INSERT INTO pais VALUES (231, 'ET', 'Etiópia');
INSERT INTO pais VALUES (232, 'ER', 'Eritréia');
INSERT INTO pais VALUES (233, 'EE', 'Estônia');
INSERT INTO pais VALUES (242, 'FJ', 'Fiji');
INSERT INTO pais VALUES (246, 'FI', 'Finlândia');
INSERT INTO pais VALUES (250, 'FR', 'França');
INSERT INTO pais VALUES (262, 'DJ', 'Djibouti');
INSERT INTO pais VALUES (266, 'GA', 'Gabão');
INSERT INTO pais VALUES (268, 'GE', 'Geórgia');
INSERT INTO pais VALUES (270, 'GM', 'Gâmbia');
INSERT INTO pais VALUES (276, 'DE', 'Alemanha');
INSERT INTO pais VALUES (288, 'GH', 'Gana');
INSERT INTO pais VALUES (296, 'KI', 'Kiribati');
INSERT INTO pais VALUES (300, 'GR', 'Grécia');
INSERT INTO pais VALUES (308, 'GD', 'Granada');
INSERT INTO pais VALUES (320, 'GT', 'Guatemala');
INSERT INTO pais VALUES (324, 'GN', 'Guiné');
INSERT INTO pais VALUES (328, 'GY', 'Guiana');
INSERT INTO pais VALUES (332, 'HT', 'Haiti');
INSERT INTO pais VALUES (340, 'HN', 'Honduras');
INSERT INTO pais VALUES (348, 'HU', 'Hungria');
INSERT INTO pais VALUES (352, 'IS', 'Islândia');
INSERT INTO pais VALUES (356, 'IN', 'Índia');
INSERT INTO pais VALUES (360, 'ID', 'Indonésia');
INSERT INTO pais VALUES (364, 'IR', 'Irã');
INSERT INTO pais VALUES (368, 'IQ', 'Iraque');
INSERT INTO pais VALUES (372, 'IE', 'Irlanda');
INSERT INTO pais VALUES (376, 'IL', 'Israel');
INSERT INTO pais VALUES (380, 'IT', 'Itália');
INSERT INTO pais VALUES (384, 'CI', 'Costa do Marfim');
INSERT INTO pais VALUES (388, 'JM', 'Jamaica');
INSERT INTO pais VALUES (392, 'JP', 'Japão');
INSERT INTO pais VALUES (398, 'KZ', 'Cazaquistão');
INSERT INTO pais VALUES (400, 'JO', 'Jordânia');
INSERT INTO pais VALUES (404, 'KE', 'Quênia');
INSERT INTO pais VALUES (408, 'KP', 'República Popular Democrática da Coréia');
INSERT INTO pais VALUES (410, 'KR', 'República da Coréia');
INSERT INTO pais VALUES (414, 'KW', 'Kuwait');
INSERT INTO pais VALUES (417, 'KG', 'Quirguistão');
INSERT INTO pais VALUES (418, 'LA', 'Laos');
INSERT INTO pais VALUES (422, 'LB', 'Líbano');
INSERT INTO pais VALUES (426, 'LS', 'Lesoto');
INSERT INTO pais VALUES (428, 'LV', 'Letônia');
INSERT INTO pais VALUES (430, 'LR', 'Libéria');
INSERT INTO pais VALUES (434, 'LY', 'Líbia');
INSERT INTO pais VALUES (438, 'LI', 'Liechtenstein');
INSERT INTO pais VALUES (440, 'LT', 'Lituânia');
INSERT INTO pais VALUES (442, 'LU', 'Luxemburgo');
INSERT INTO pais VALUES (450, 'MG', 'Madagáscar');
INSERT INTO pais VALUES (454, 'MW', 'Malauí');
INSERT INTO pais VALUES (458, 'MY', 'Malásia');
INSERT INTO pais VALUES (462, 'MV', 'Maldivas');
INSERT INTO pais VALUES (466, 'ML', 'Mali');
INSERT INTO pais VALUES (470, 'MT', 'Malta');
INSERT INTO pais VALUES (478, 'MR', 'Mauritânia');
INSERT INTO pais VALUES (480, 'MU', 'Maurício');
INSERT INTO pais VALUES (484, 'MX', 'México');
INSERT INTO pais VALUES (492, 'MC', 'Mônaco');
INSERT INTO pais VALUES (496, 'MN', 'Mongólia');
INSERT INTO pais VALUES (498, 'MD', 'Moldávia');
INSERT INTO pais VALUES (499, 'ME', 'Montenegro');
INSERT INTO pais VALUES (504, 'MA', 'Marrocos');
INSERT INTO pais VALUES (508, 'MZ', 'Moçambique');
INSERT INTO pais VALUES (512, 'OM', 'Omã');
INSERT INTO pais VALUES (516, 'NA', 'Namíbia');
INSERT INTO pais VALUES (520, 'NR', 'Nauru');
INSERT INTO pais VALUES (524, 'NP', 'Nepal');
INSERT INTO pais VALUES (528, 'NL', 'Holanda');
INSERT INTO pais VALUES (548, 'VU', 'Vanuatu');
INSERT INTO pais VALUES (554, 'NZ', 'Nova Zelândia');
INSERT INTO pais VALUES (558, 'NI', 'Nicarágua');
INSERT INTO pais VALUES (562, 'NE', 'Níger');
INSERT INTO pais VALUES (566, 'NG', 'Nigéria');
INSERT INTO pais VALUES (578, 'NO', 'Noruega');
INSERT INTO pais VALUES (583, 'FM', 'Micronésia');
INSERT INTO pais VALUES (584, 'MH', 'Ilhas Marshall');
INSERT INTO pais VALUES (585, 'PW', 'Palau');
INSERT INTO pais VALUES (586, 'PK', 'Paquistão');
INSERT INTO pais VALUES (591, 'PA', 'Panamá');
INSERT INTO pais VALUES (598, 'PG', 'Papua Nova Guiné');
INSERT INTO pais VALUES (600, 'PY', 'Paraguai');
INSERT INTO pais VALUES (604, 'PE', 'Peru');
INSERT INTO pais VALUES (608, 'PH', 'Filipinas');
INSERT INTO pais VALUES (616, 'PL', 'Polônia');
INSERT INTO pais VALUES (620, 'PT', 'Portugal');
INSERT INTO pais VALUES (624, 'GW', 'Guiné-Bissau');
INSERT INTO pais VALUES (626, 'TL', 'Timor Leste');
INSERT INTO pais VALUES (634, 'QA', 'Catar');
INSERT INTO pais VALUES (642, 'RO', 'Romênia');
INSERT INTO pais VALUES (643, 'RU', 'Rússia (Federação Russa)');
INSERT INTO pais VALUES (646, 'RW', 'Ruanda');
INSERT INTO pais VALUES (659, 'KN', 'São Cristóvão e Nevis');
INSERT INTO pais VALUES (662, 'LC', 'Santa Lúcia');
INSERT INTO pais VALUES (670, 'VC', 'São Vicente e Granadinas');
INSERT INTO pais VALUES (674, 'SM', 'San Marino');
INSERT INTO pais VALUES (678, 'ST', 'São Tomé e Príncipe');
INSERT INTO pais VALUES (682, 'SA', 'Arábia Saudita');
INSERT INTO pais VALUES (686, 'SN', 'Senegal');
INSERT INTO pais VALUES (688, 'RS', 'Sérvia');
INSERT INTO pais VALUES (690, 'SC', 'Seichelles');
INSERT INTO pais VALUES (694, 'SL', 'Serra Leoa');
INSERT INTO pais VALUES (702, 'SG', 'Singapura');
INSERT INTO pais VALUES (703, 'SK', 'Eslováquia');
INSERT INTO pais VALUES (704, 'VN', 'Vietnã');
INSERT INTO pais VALUES (705, 'SI', 'Eslovênia');
INSERT INTO pais VALUES (706, 'SO', 'Somália');
INSERT INTO pais VALUES (710, 'ZA', 'África do Sul');
INSERT INTO pais VALUES (716, 'ZW', 'Zimbábue');
INSERT INTO pais VALUES (724, 'ES', 'Espanha');
INSERT INTO pais VALUES (728, 'SS', 'Sudão do Sul');
INSERT INTO pais VALUES (729, 'SD', 'Sudão');
INSERT INTO pais VALUES (740, 'SR', 'Suriname');
INSERT INTO pais VALUES (748, 'SZ', 'Eswatini');
INSERT INTO pais VALUES (752, 'SE', 'Suécia');
INSERT INTO pais VALUES (756, 'CH', 'Suíça');
INSERT INTO pais VALUES (760, 'SY', 'Síria');
INSERT INTO pais VALUES (762, 'TJ', 'Tadjiquistão');
INSERT INTO pais VALUES (764, 'TH', 'Tailândia');
INSERT INTO pais VALUES (768, 'TG', 'Togo');
INSERT INTO pais VALUES (776, 'TO', 'Tonga');
INSERT INTO pais VALUES (780, 'TT', 'Trinidad e Tobago');
INSERT INTO pais VALUES (784, 'AE', 'Emirados Árabes Unidos');
INSERT INTO pais VALUES (788, 'TN', 'Tunísia');
INSERT INTO pais VALUES (792, 'TR', 'Turquia');
INSERT INTO pais VALUES (795, 'TM', 'Turcomenistão');
INSERT INTO pais VALUES (798, 'TV', 'Tuvalu');
INSERT INTO pais VALUES (800, 'UG', 'Uganda');
INSERT INTO pais VALUES (804, 'UA', 'Ucrânia');
INSERT INTO pais VALUES (807, 'MK', 'Macedônia do Norte');
INSERT INTO pais VALUES (818, 'EG', 'Egito');
INSERT INTO pais VALUES (826, 'GB', 'Reino Unido');
INSERT INTO pais VALUES (834, 'TZ', 'Tanzânia');
INSERT INTO pais VALUES (840, 'US', 'Estados Unidos da América');
INSERT INTO pais VALUES (854, 'BF', 'Burkina Faso');
INSERT INTO pais VALUES (858, 'UY', 'Uruguai');
INSERT INTO pais VALUES (860, 'UZ', 'Uzbequistão');
INSERT INTO pais VALUES (862, 'VE', 'Venezuela');
INSERT INTO pais VALUES (882, 'WS', 'Samoa');
INSERT INTO pais VALUES (887, 'YE', 'Iêmen');

INSERT INTO estado VALUES (11, 'RO', 'Rondônia', 1);
INSERT INTO estado VALUES (12, 'AC', 'Acre', 1);
INSERT INTO estado VALUES (13, 'AM', 'Amazonas', 1);
INSERT INTO estado VALUES (14, 'RR', 'Roraima', 1);
INSERT INTO estado VALUES (15, 'PA', 'Pará', 1);
INSERT INTO estado VALUES (16, 'AP', 'Amapá', 1);
INSERT INTO estado VALUES (17, 'TO', 'Tocantins', 1);
INSERT INTO estado VALUES (21, 'MA', 'Maranhão', 2);
INSERT INTO estado VALUES (22, 'PI', 'Piauí', 2);
INSERT INTO estado VALUES (23, 'CE', 'Ceará', 2);
INSERT INTO estado VALUES (24, 'RN', 'Rio Grande do Norte', 2);
INSERT INTO estado VALUES (25, 'PB', 'Paraíba', 2);
INSERT INTO estado VALUES (26, 'PE', 'Pernambuco', 2);
INSERT INTO estado VALUES (27, 'AL', 'Alagoas', 2);
INSERT INTO estado VALUES (28, 'SE', 'Sergipe', 2);
INSERT INTO estado VALUES (29, 'BA', 'Bahia', 2);
INSERT INTO estado VALUES (31, 'MG', 'Minas Gerais', 3);
INSERT INTO estado VALUES (32, 'ES', 'Espírito Santo', 3);
INSERT INTO estado VALUES (33, 'RJ', 'Rio de Janeiro', 3);
INSERT INTO estado VALUES (35, 'SP', 'São Paulo', 3);
INSERT INTO estado VALUES (41, 'PR', 'Paraná', 4);
INSERT INTO estado VALUES (42, 'SC', 'Santa Catarina', 4);
INSERT INTO estado VALUES (43, 'RS', 'Rio Grande do Sul', 4);
INSERT INTO estado VALUES (50, 'MS', 'Mato Grosso do Sul', 5);
INSERT INTO estado VALUES (51, 'MT', 'Mato Grosso', 5);
INSERT INTO estado VALUES (52, 'GO', 'Goiás', 5);
INSERT INTO estado VALUES (53, 'DF', 'Distrito Federal', 5);

INSERT INTO cidade (id, nome, estado_id) VALUES (1, 'Uberlândia', 31);
INSERT INTO cidade (id, nome, estado_id) VALUES (2, 'Belo Horizonte', 31);
INSERT INTO cidade (id, nome, estado_id) VALUES (3, 'São Paulo', 35);
INSERT INTO cidade (id, nome, estado_id) VALUES (4, 'Campinas', 35);
INSERT INTO cidade (id, nome, estado_id) VALUES (5, 'Fortaleza', 23);

INSERT INTO empresa (cnpj, razao_social,dt_inclusao,dt_atualizacao) VALUES ('72710850000194', 'Juan e Mariana Comercio de Bebidas ME',utc_timestamp, utc_timestamp);
INSERT INTO empresa (cnpj, razao_social,dt_inclusao,dt_atualizacao) VALUES ('41811216000114', 'Emilly e Larissa Padaria Ltda',utc_timestamp, utc_timestamp);

INSERT INTO catalogo_escola (nome, categoria_administrativa_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, localizacao_id, endereco_cidade_id, endereco_pais_id, situacao_escola, codigo_escola, crede_id, dt_inclusao, dt_atualizacao) VALUES ('Colegio 21 de Abril', 2, 'Monte Castelo', '60325450', NULL, 'Rua Benjamim Barroso', '820', 2, 5, 76, 1, 23064641, NULL, utc_timestamp, utc_timestamp);
INSERT INTO catalogo_escola (nome, categoria_administrativa_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, localizacao_id, endereco_cidade_id, endereco_pais_id, situacao_escola, codigo_escola, crede_id, dt_inclusao, dt_atualizacao) VALUES ('Academos Organizacao Educacional', 2, 'Aldeota', '60160280', NULL, 'Rua Costa Barros Barroso', NULL, 2,5, 76, 1, 23064650, NULL, utc_timestamp, utc_timestamp);
INSERT INTO catalogo_escola (nome, categoria_administrativa_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, localizacao_id, endereco_cidade_id, endereco_pais_id, situacao_escola, codigo_escola, crede_id, dt_inclusao, dt_atualizacao) VALUES ('EEM Governador Adauto Bezerra', 1, 'Fatima', '60411150', NULL, 'Rua Mons Liberato', '1850',2, 5, 76, 1, 23064684, 23, utc_timestamp, utc_timestamp);
