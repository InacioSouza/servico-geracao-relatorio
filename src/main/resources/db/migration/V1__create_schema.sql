CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE sistema (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         nome VARCHAR(250) NOT NULL,
                         descricao TEXT,
                         versao BIGINT NOT NULL
);

CREATE TABLE relatorio (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           titulo VARCHAR(250) NOT NULL,
                           subtitulo VARCHAR(250),
                           nome VARCHAR(250),
                           descricao_tecnica TEXT,
                           informacao TEXT,
                           sistema_id BIGINT NOT NULL,
                           data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           versao BIGINT NOT NULL,

                           FOREIGN KEY (sistema_id) REFERENCES sistema(id)
);

CREATE TABLE versao_relatorio(
                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 nome_arquivo VARCHAR(250) NOT NULL,
                                 relatorio_id UUID NOT NULL,
                                 descricao_versao TEXT,
                                 tipo_arquivo VARCHAR(10) NOT NULL,
                                 tipo_final_relatorio VARCHAR(10) NOT NULL,
                                 arquivo_compilado BYTEA,
                                 arquivo_original BYTEA NOT NULL,
                                 data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                 versao BIGINT NOT NULL,

                                 FOREIGN KEY (relatorio_id) REFERENCES relatorio(id)
);

CREATE TABLE arquivo_adicional(
                                  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                  versao_relatorio_id UUID NOT NULL,
                                  tipo_arquivo VARCHAR(10),
                                  arquivo_compilado BYTEA,
                                  arquivo_original BYTEA NOT NULL,
                                  versao BIGINT NOT NULL,

                                  FOREIGN KEY (versao_relatorio_id) REFERENCES versao_relatorio(id)
);