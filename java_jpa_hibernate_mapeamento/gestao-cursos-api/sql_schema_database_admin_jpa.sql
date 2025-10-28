-- Tabela Professor
CREATE TABLE Professor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nomeCompleto TEXT,
    matricula TEXT,
    email TEXT
);

-- Tabela MaterialCurso
CREATE TABLE MaterialCurso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    url TEXT
);

-- Tabela Curso
CREATE TABLE Curso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT,
    sigla TEXT,
    professor_id INTEGER,
    material_id INTEGER,
    FOREIGN KEY (professor_id) REFERENCES Professor(id),
    FOREIGN KEY (material_id) REFERENCES MaterialCurso(id)
);

-- Tabela Aluno
CREATE TABLE Aluno (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nomeCompleto TEXT,
    matricula TEXT,
    nascimento DATE,
    email TEXT
);

-- Tabela Endereco
CREATE TABLE Endereco (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    logradouro TEXT,
    endereco TEXT,
    numero TEXT,
    bairro TEXT,
    cidade TEXT,
    estado TEXT,
    cep INTEGER,
    aluno_id INTEGER,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);

-- Tabela Telefone
CREATE TABLE Telefone (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    DDD TEXT,
    numero TEXT,
    aluno_id INTEGER,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);

-- Tabela de associação Curso_Aluno (ManyToMany)
CREATE TABLE curso_aluno (
    curso_id INTEGER,
    aluno_id INTEGER,
    PRIMARY KEY (curso_id, aluno_id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id),
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);
