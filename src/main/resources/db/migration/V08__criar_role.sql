DROP TABLE IF EXISTS ROLE CASCADE;
CREATE TABLE ROLE (
	NOME_ROLE VARCHAR(255) PRIMARY KEY
);

INSERT INTO ROLE (NOME_ROLE) VALUES ('ROLE_ADM');
INSERT INTO ROLE (NOME_ROLE) VALUES ('ROLE_CLI');
INSERT INTO ROLE (NOME_ROLE) VALUES ('ROLE_FIS');
--INSERT INTO ROLE (NOME_ROLE) VALUES ('ROLE_INA');
