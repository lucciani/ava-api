ALTER TABLE aluno ADD id BIGINT NULL;
ALTER TABLE aluno CHANGE id id BIGINT NULL FIRST;
CREATE INDEX aluno_id USING BTREE ON aluno (id);
ALTER TABLE aluno MODIFY COLUMN id bigint(20) DEFAULT NULL auto_increment NOT NULL;