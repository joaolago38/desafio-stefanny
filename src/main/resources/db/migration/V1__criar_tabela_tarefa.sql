-- Arquivo: V1__criar_tabela_tarefa.sql

-- Criação da tabela Tarefa
CREATE TABLE Tarefa (
                        Id INT PRIMARY KEY IDENTITY(1,1),      -- Identificador único com incremento automático
                        Titulo NVARCHAR(200) NOT NULL,        -- Título da tarefa
                        Descricao NVARCHAR(MAX),              -- Descrição detalhada da tarefa
                        DataCriacao DATETIME DEFAULT GETDATE(), -- Data e hora de criação
                        Status NVARCHAR(50) NOT NULL          -- Status da tarefa
);