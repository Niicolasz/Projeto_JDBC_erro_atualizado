-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS escola;
USE escola;

-- Criar tabela de alunos
CREATE TABLE IF NOT EXISTS aluno (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    endereco VARCHAR(200) NOT NULL
);

-- Criar tabela de disciplinas
CREATE TABLE IF NOT EXISTS disciplina (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(10) NOT NULL UNIQUE
);

-- Criar tabela de relacionamento aluno_disciplina
CREATE TABLE IF NOT EXISTS aluno_disciplina (
    aluno_id BIGINT,
    disciplina_id BIGINT,
    PRIMARY KEY (aluno_id, disciplina_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id) ON DELETE CASCADE
);

-- Inserir algumas disciplinas de exemplo
INSERT INTO disciplina (nome, codigo) VALUES
('Matemática', 'MAT001'),
('Português', 'PORT001'),
('História', 'HIST001'),
('Geografia', 'GEO001'),
('Física', 'FIS001'),
('Química', 'QUIM001'),
('Biologia', 'BIO001'),
('Inglês', 'ING001'),
('Educação Física', 'EDF001'),
('Artes', 'ART001'); 