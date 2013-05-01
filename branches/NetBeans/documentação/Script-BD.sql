-- DROP TABLE usuario;

CREATE TABLE usuario
(
  usua_cod integer NOT NULL,
  usua_nome character varying(40),
  usua_login character varying(20),
  usua_senha character varying(40),
  CONSTRAINT pk_usuario PRIMARY KEY (usua_cod)
);

-- usuario inicial senha: 1
INSERT INTO usuario(usua_cod, usua_nome, usua_login, usua_senha) 
VALUES (1, 'ADMINISTRADOR', 'admin', 'c4ca4238a0b923820dcc509a6f75849b');

-- DROP TABLE cedente;

CREATE TABLE cedente
(
  ceden_cod integer NOT NULL,
  ceden_nome character varying(50),
  ceden_cpfcnpj character varying(18),
  ceden_agencia character varying(10),
  ceden_operacao character varying(3),
  ceden_conta character varying(10),
  ceden_dv character varying(1),
  ceden_nossonumero character varying(15),
  ceden_especie character varying(2),
  ceden_moeda character varying(4),
  ceden_aceite character varying(1),
  ceden_multa numeric(8,2),
  ceden_multa_dias integer,
  ceden_descontos numeric(8,2),
  ceden_descontos_dia integer,
  ceden_juros numeric(8,2),
  ceden_msg_sacado text,
  ceden_msg1 character varying(80),
  ceden_msg2 character varying(80),
  ceden_msg3 character varying(80),
  ceden_msg4 character varying(80),
  ceden_modalidade character varying(1),
  ceden_emissao_bloq character varying(1),
  ceden_cedente character varying(10),
  ceden_tipo character varying(2),
  ceden_avalista boolean DEFAULT false,
  CONSTRAINT pk_cedente PRIMARY KEY (ceden_cod)
);

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
