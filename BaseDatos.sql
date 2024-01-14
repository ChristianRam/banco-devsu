--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    clave integer NOT NULL,
    estado boolean NOT NULL,
    cliente_id bigint NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: cuentas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuentas (
    estado boolean NOT NULL,
    saldo_inicial numeric(38,2) NOT NULL,
    cliente_id bigint NOT NULL,
    cuenta_id bigint NOT NULL,
    tipo_cuenta character varying(10) NOT NULL,
    numero_cuenta character varying(20) NOT NULL,
    CONSTRAINT cuentas_tipo_cuenta_check CHECK (((tipo_cuenta)::text = ANY ((ARRAY['AHORROS'::character varying, 'CORRIENTE'::character varying])::text[])))
);


ALTER TABLE public.cuentas OWNER TO postgres;

--
-- Name: cuentas_cuenta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuentas_cuenta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cuentas_cuenta_id_seq OWNER TO postgres;

--
-- Name: cuentas_cuenta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuentas_cuenta_id_seq OWNED BY public.cuentas.cuenta_id;


--
-- Name: movimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimientos (
    fecha date NOT NULL,
    saldo numeric(38,2) NOT NULL,
    valor numeric(38,2) NOT NULL,
    cuenta_id bigint,
    movimiento_id bigint NOT NULL,
    tipo_movimiento character varying(10) NOT NULL,
    CONSTRAINT movimientos_tipo_movimiento_check CHECK (((tipo_movimiento)::text = ANY ((ARRAY['RETIRO'::character varying, 'DEPOSITO'::character varying])::text[])))
);


ALTER TABLE public.movimientos OWNER TO postgres;

--
-- Name: movimientos_movimiento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimientos_movimiento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.movimientos_movimiento_id_seq OWNER TO postgres;

--
-- Name: movimientos_movimiento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimientos_movimiento_id_seq OWNED BY public.movimientos.movimiento_id;


--
-- Name: personas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personas (
    edad integer NOT NULL,
    persona_id bigint NOT NULL,
    identificacion character varying(10) NOT NULL,
    telefono character varying(10) NOT NULL,
    genero character varying(30) NOT NULL,
    direccion character varying(45) NOT NULL,
    nombre character varying(50) NOT NULL,
    CONSTRAINT personas_genero_check CHECK (((genero)::text = ANY ((ARRAY['MASCULINO'::character varying, 'FEMENINO'::character varying, 'OTRO'::character varying])::text[])))
);


ALTER TABLE public.personas OWNER TO postgres;

--
-- Name: personas_persona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.personas_persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.personas_persona_id_seq OWNER TO postgres;

--
-- Name: personas_persona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.personas_persona_id_seq OWNED BY public.personas.persona_id;


--
-- Name: cuentas cuenta_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas ALTER COLUMN cuenta_id SET DEFAULT nextval('public.cuentas_cuenta_id_seq'::regclass);


--
-- Name: movimientos movimiento_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos ALTER COLUMN movimiento_id SET DEFAULT nextval('public.movimientos_movimiento_id_seq'::regclass);


--
-- Name: personas persona_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas ALTER COLUMN persona_id SET DEFAULT nextval('public.personas_persona_id_seq'::regclass);


--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (clave, estado, cliente_id) FROM stdin;
\.


--
-- Data for Name: cuentas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuentas (estado, saldo_inicial, cliente_id, cuenta_id, tipo_cuenta, numero_cuenta) FROM stdin;
\.


--
-- Data for Name: movimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimientos (fecha, saldo, valor, cuenta_id, movimiento_id, tipo_movimiento) FROM stdin;
\.


--
-- Data for Name: personas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personas (edad, persona_id, identificacion, telefono, genero, direccion, nombre) FROM stdin;
\.


--
-- Name: cuentas_cuenta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuentas_cuenta_id_seq', 1, false);


--
-- Name: movimientos_movimiento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimientos_movimiento_id_seq', 1, false);


--
-- Name: personas_persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personas_persona_id_seq', 1, false);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cliente_id);


--
-- Name: cuentas cuentas_numero_cuenta_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_numero_cuenta_key UNIQUE (numero_cuenta);


--
-- Name: cuentas cuentas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pkey PRIMARY KEY (cuenta_id);


--
-- Name: movimientos movimientos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (movimiento_id);


--
-- Name: personas personas_identificacion_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_identificacion_key UNIQUE (identificacion);


--
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (persona_id);


--
-- Name: clientes fk3b2u85sny49u8gmk3bkrt3gjy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT fk3b2u85sny49u8gmk3bkrt3gjy FOREIGN KEY (cliente_id) REFERENCES public.personas(persona_id);


--
-- Name: movimientos fk4moe88hxuohcysas5h70mdc09; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT fk4moe88hxuohcysas5h70mdc09 FOREIGN KEY (cuenta_id) REFERENCES public.cuentas(cuenta_id);


--
-- PostgreSQL database dump complete
--

