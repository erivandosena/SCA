/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     06/02/2012 10:58:36                          */
/* Update on:      01/04/2012 14:11:46                          */
/*==============================================================*/

-- Database: sistema_sca
-- DROP DATABASE sistema_sca;

CREATE DATABASE sistema_sca
  WITH OWNER = postgres
       ENCODING = 'LATIN1';

-- Table: usuario
-- DROP TABLE usuario;
CREATE TABLE usuario
(
  usua_cod integer NOT NULL,
  usua_nome character varying(40),
  usua_login character varying(20),
  usua_senha character varying(40),
  CONSTRAINT pk_usuario PRIMARY KEY (usua_cod)
);

-- usuario/senha: admin
INSERT INTO usuario(usua_cod, usua_nome, usua_login, usua_senha)VALUES (1, 'Administrador do Sistema', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- Table: locador
-- DROP TABLE locador;
CREATE TABLE locador
(
  locad_cod integer NOT NULL,
  locad_nome character varying(50),
  locad_rg character varying(20),
  locad_cpf character varying(14),
  locad_estado_civil character varying(20),
  locad_profissao character varying(30),
  locad_nacionalidade character varying(15),
  locad_endereco character varying(50),
  locad_num_endereco character varying(5),
  locad_bairro character varying(30),
  locad_cep character varying(10),
  locad_cidade character varying(30),
  locad_uf character(2),
  CONSTRAINT pk_locador PRIMARY KEY (locad_cod)
);

-- Table: locatario
-- DROP TABLE locatario;
CREATE TABLE locatario
(
  locat_cod integer NOT NULL,
  locat_data_cadastro date,
  locat_nome character varying(50),
  locat_rg character varying(20),
  locat_cpf character varying(14),
  locat_estado_civil character varying(20),
  locat_profissao character varying(30),
  locat_nacionalidade character varying(15),
  locat_endereco character varying(50),
  locat_num_endereco character varying(5),
  locat_bairro character varying(30),
  locat_cep character varying(10),
  locat_cidade character varying(30),
  locat_uf character(2),
  locat_telefone character varying(13),
  locat_status boolean,
  CONSTRAINT pk_locatario PRIMARY KEY (locat_cod)
);

-- Table: contrato
-- DROP TABLE contrato;
CREATE TABLE contrato
(
  contr_cod integer NOT NULL,
  locad_cod integer NOT NULL,
  locat_cod integer NOT NULL,
  contr_numero character varying(10),
  contr_descricao character varying(100),
  contr_mensalidade numeric(8,2),
  contr_prazo integer,
  contr_data_inicial date,
  contr_data_final date,
  CONSTRAINT pk_contrato PRIMARY KEY (contr_cod),
  CONSTRAINT fk_contrato_associa_locador FOREIGN KEY (locad_cod)
      REFERENCES locador (locad_cod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_contrato_associa_locatari FOREIGN KEY (locat_cod)
      REFERENCES locatario (locat_cod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: carne
-- DROP TABLE carne;
CREATE TABLE carne
(
  carne_cod integer NOT NULL,
  contr_cod integer NOT NULL,
  carne_observacao character varying(100),
  CONSTRAINT pk_carne PRIMARY KEY (carne_cod),
  CONSTRAINT fk_carne_associa_contrato FOREIGN KEY (contr_cod)
      REFERENCES contrato (contr_cod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: mensalidade
-- DROP TABLE mensalidade;
CREATE TABLE mensalidade
(
  mensa_cod integer NOT NULL,
  carne_cod integer NOT NULL,
  mensa_valor numeric(8,2),
  mensa_vencimento date,
  mensa_numero character varying(10),
  mensa_observacao character varying(100),
  CONSTRAINT pk_mensalidade PRIMARY KEY (mensa_cod),
  CONSTRAINT fk_mensalid_associa_carne FOREIGN KEY (carne_cod)
      REFERENCES carne (carne_cod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

