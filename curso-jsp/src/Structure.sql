-- Database: "curso-jsp"

-- DROP DATABASE "curso-jsp";

CREATE DATABASE "curso-jsp"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;



-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
  id bigint NOT NULL DEFAULT nextval('usersequence'::regclass),
  login character varying(500),
  senha character varying(20),
  nome character varying(500),
  telefone character varying(20),
  cep character varying(200),
  rua character varying(200),
  bairro character varying(200),
  cidade character varying(200),
  estado character varying(200),
  ibge character varying(200),
  fotobase64 text,
  contenttype text,
  curriculobase64 text,
  contenttypecurriculo text,
  fotobase64miniatura text,
  ativo boolean,
  sexo character varying(200),
  perfil character varying(200),
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;
  
  INSERT INTO public.usuario(login, senha)VALUES ('admin', 'admin');

  -- Table: public.telefone

-- DROP TABLE public.telefone;

CREATE TABLE public.telefone
(
  id bigint NOT NULL DEFAULT nextval('fonesequence'::regclass),
  numero character varying(500),
  tipo character varying(500),
  usuario bigint NOT NULL,
  CONSTRAINT fone_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.telefone
  OWNER TO postgres;

  
  -- Table: public.produto

-- DROP TABLE public.produto;

CREATE TABLE public.produto
(
  id bigint NOT NULL DEFAULT nextval('produtosequence'::regclass),
  nome character varying(500),
  quantidade numeric(10,4),
  valor numeric(10,2),
  CONSTRAINT produto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.produto
  OWNER TO postgres;

  
  
  
  /*******************************SEQUENCE*****************************************/
  -- Sequence: public.usersequence

-- DROP SEQUENCE public.usersequence;

CREATE SEQUENCE public.usersequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.usersequence
  OWNER TO postgres;

  
  -- Sequence: public.produtosequence

-- DROP SEQUENCE public.produtosequence;

CREATE SEQUENCE public.produtosequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.produtosequence
  OWNER TO postgres;
  
  -- Sequence: public.fonesequence

-- DROP SEQUENCE public.fonesequence;

CREATE SEQUENCE public.fonesequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.fonesequence
  OWNER TO postgres;



  
  
  
  -- Table: public.categoria

-- DROP TABLE public.categoria;

CREATE TABLE public.categoria
(
  id bigint NOT NULL DEFAULT nextval('categoriasequence'::regclass),
  nome character varying(500),
  CONSTRAINT categoria_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.categoria
  OWNER TO postgres;

  
  -- Sequence: public.categoriasequence

-- DROP SEQUENCE public.categoriasequence;

CREATE SEQUENCE public.categoriasequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.categoriasequence
  OWNER TO postgres;
  
  
INSERT INTO public.categoria(nome) VALUES ('Bebida');
INSERT INTO public.categoria(nome) VALUES ('Higiene');
INSERT INTO public.categoria(nome) VALUES ('Quimico');
INSERT INTO public.categoria(nome) VALUES ('Doces');
INSERT INTO public.categoria(nome) VALUES ('Grãos');



ALTER TABLE produto ADD COLUMN categoria_id bigint;
ALTER TABLE produto ADD CONSTRAINT categoria_fk FOREIGN KEY (categoria_id) REFERENCES  categoria(id);
