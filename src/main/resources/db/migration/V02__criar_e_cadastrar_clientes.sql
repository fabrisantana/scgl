DROP TABLE IF EXISTS CLIENTE CASCADE;
CREATE TABLE CLIENTE(
    	CLI_ID SERIAL PRIMARY KEY,
	CLI_RAZAO_SOCIAL VARCHAR(150) NOT NULL,
    	CLI_NOME_FANTASIA VARCHAR(150) NOT NULL,
	CLI_INSCRICAO_ESTADUAL INTEGER NOT NULL,
	CLI_CNPJ VARCHAR(14) NOT NULL,
	CLI_EMAIL VARCHAR(100) NOT NULL,
	CLI_TELEFONE VARCHAR(12),
	CLI_DT_EXCLUSAO TIMESTAMP WITHOUT TIME ZONE,
	CLI_STATUS VARCHAR(10) NOT NULL,
	CLI_CIDADE VARCHAR(30) NOT NULL,
	CLI_CEP INTEGER NOT NULL,
	CLI_LOGRADOURO VARCHAR(100) NOT NULL,
	CLI_COMPLEMENTO VARCHAR(50) NOT NULL,
	CLI_DT_ATUALIZACAO TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

INSERT INTO CLIENTE (CLI_RAZAO_SOCIAL, CLI_NOME_FANTASIA, CLI_INSCRICAO_ESTADUAL, CLI_CNPJ, CLI_EMAIL, CLI_TELEFONE, CLI_DT_EXCLUSAO, CLI_STATUS, CLI_CIDADE, CLI_CEP, CLI_LOGRADOURO, CLI_COMPLEMENTO) 
values('Unimed Goiania', 'Unimed Goiania', 5331666, '02762626110145', 'Unimed@gmail.com', '32168000', null, 'Ativo', 'Goiania', 7455000, 'Av T-7', 'N 540');


INSERT INTO CLIENTE (CLI_RAZAO_SOCIAL, CLI_NOME_FANTASIA, CLI_INSCRICAO_ESTADUAL, CLI_CNPJ, CLI_EMAIL, CLI_TELEFONE, CLI_DT_EXCLUSAO, CLI_STATUS, CLI_CIDADE, CLI_CEP, CLI_LOGRADOURO, CLI_COMPLEMENTO) 
values('Celg Distribuição', 'Enel', 5331666, '02762626110145', 'Unimed@gmail.com', '32168000', null, 'Ativo', 'Goiania', 7455000, 'Av T-2', 'N 540');
