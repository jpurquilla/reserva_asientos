--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-10-29 17:54:13

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
-- TOC entry 214 (class 1259 OID 122882)
-- Name: evento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evento (
    estado integer,
    nombre character varying(255),
    descripcion character varying(255),
    foto bytea,
    horafin time(6) without time zone,
    horainicio time(6) without time zone,
    fecha date,
    idevento integer NOT NULL
);


ALTER TABLE public.evento OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 122887)
-- Name: evento_idevento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evento_idevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evento_idevento_seq OWNER TO postgres;

--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 215
-- Name: evento_idevento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evento_idevento_seq OWNED BY public.evento.idevento;


--
-- TOC entry 223 (class 1259 OID 131115)
-- Name: localidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.localidad (
    codigo character varying NOT NULL,
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    estado integer NOT NULL
);


ALTER TABLE public.localidad OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 122888)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    idmenu integer NOT NULL,
    url character varying,
    nombre character varying NOT NULL
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 122893)
-- Name: menuxperfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuxperfil (
    idperfil integer NOT NULL,
    idmenu integer NOT NULL
);


ALTER TABLE public.menuxperfil OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 122896)
-- Name: perfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.perfil (
    idperfil integer NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.perfil OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 122901)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    idpersona integer NOT NULL,
    nombres character varying NOT NULL,
    apellidos character varying NOT NULL,
    dui character varying,
    email character varying,
    telefono character varying
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 122906)
-- Name: persona_idpersona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_idpersona_seq OWNER TO postgres;

--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 220
-- Name: persona_idpersona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_idpersona_seq OWNED BY public.persona.idpersona;


--
-- TOC entry 222 (class 1259 OID 131110)
-- Name: seccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seccion (
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    nombre character varying(50) NOT NULL,
    precio numeric(14,2) NOT NULL
);


ALTER TABLE public.seccion OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 122907)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    codusr character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    fechacrea timestamp(6) without time zone NOT NULL,
    idpersona integer,
    idperfil integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 3202 (class 2604 OID 122912)
-- Name: evento idevento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evento ALTER COLUMN idevento SET DEFAULT nextval('public.evento_idevento_seq'::regclass);


--
-- TOC entry 3203 (class 2604 OID 122913)
-- Name: persona idpersona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);


--
-- TOC entry 3367 (class 0 OID 122882)
-- Dependencies: 214
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evento (estado, nombre, descripcion, foto, horafin, horainicio, fecha, idevento) FROM stdin;
10	Evento test	Este es un test	\N	17:00:00	15:00:00	2023-10-29	1
\.


--
-- TOC entry 3376 (class 0 OID 131115)
-- Dependencies: 223
-- Data for Name: localidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.localidad (codigo, idevento, idseccion, estado) FROM stdin;
UP1	1	1	10
UP2	1	1	10
UP3	1	1	10
P1	1	2	10
P3	1	2	10
P4	1	2	10
VIP1	1	3	10
VIP2	1	3	10
VIP3	1	3	10
VIP4	1	3	10
VIP5	1	3	10
G1	1	4	10
G2	1	4	10
G3	1	4	10
G5	1	4	10
G6	1	4	10
G4	1	4	30
P2	1	2	30
UP4	1	1	10
UP5	1	1	10
UP6	1	1	10
UP7	1	1	10
UP8	1	1	10
UP9	1	1	10
UP10	1	1	10
P5	1	2	10
P6	1	2	10
P7	1	2	10
P8	1	2	10
P9	1	2	10
P10	1	2	10
P11	1	2	10
P12	1	2	10
VIP6	1	3	10
VIP7	1	3	10
VIP8	1	3	10
VIP9	1	3	10
VIP10	1	3	10
VIP11	1	3	10
VIP12	1	3	10
VIP13	1	3	10
VIP14	1	3	10
VIP15	1	3	10
VIP16	1	3	10
G7	1	4	10
G8	1	4	10
G9	1	4	10
G10	1	4	10
G11	1	4	10
G12	1	4	10
G13	1	4	10
G14	1	4	10
G15	1	4	10
G16	1	4	10
G17	1	4	10
G18	1	4	10
G19	1	4	10
G20	1	4	10
G21	1	4	10
G22	1	4	10
G23	1	4	10
G24	1	4	10
G25	1	4	10
G26	1	4	10
G27	1	4	10
G28	1	4	10
G29	1	4	10
G30	1	4	10
UP11	1	1	10
UP12	1	1	10
P13	1	2	10
P14	1	2	10
P15	1	2	10
P16	1	2	10
P17	1	2	10
P18	1	2	10
VIP17	1	3	10
VIP18	1	3	10
VIP19	1	3	10
VIP20	1	3	10
VIP21	1	3	10
VIP22	1	3	10
VIP23	1	3	10
VIP24	1	3	10
\.


--
-- TOC entry 3369 (class 0 OID 122888)
-- Dependencies: 216
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.menu (idmenu, url, nombre) FROM stdin;
10	administrador/page1	menu prueba
\.


--
-- TOC entry 3370 (class 0 OID 122893)
-- Dependencies: 217
-- Data for Name: menuxperfil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.menuxperfil (idperfil, idmenu) FROM stdin;
10	10
\.


--
-- TOC entry 3371 (class 0 OID 122896)
-- Dependencies: 218
-- Data for Name: perfil; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.perfil (idperfil, descripcion) FROM stdin;
10	Administrador
\.


--
-- TOC entry 3372 (class 0 OID 122901)
-- Dependencies: 219
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (idpersona, nombres, apellidos, dui, email, telefono) FROM stdin;
1	Juan Pablo	Urquilla	000000-0	jpurquilla@gmail.com	1234-1234
\.


--
-- TOC entry 3375 (class 0 OID 131110)
-- Dependencies: 222
-- Data for Name: seccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seccion (idevento, idseccion, nombre, precio) FROM stdin;
1	1	Ultra Premium	100.00
1	2	Premium	75.00
1	3	VIP	50.00
1	4	General	25.00
\.


--
-- TOC entry 3374 (class 0 OID 122907)
-- Dependencies: 221
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (codusr, password, fechacrea, idpersona, idperfil) FROM stdin;
jpurquilla	admin	2023-12-10 00:00:00	1	10
\.


--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 215
-- Name: evento_idevento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evento_idevento_seq', 1, false);


--
-- TOC entry 3385 (class 0 OID 0)
-- Dependencies: 220
-- Name: persona_idpersona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_idpersona_seq', 1, true);


--
-- TOC entry 3205 (class 2606 OID 122915)
-- Name: evento idevento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idevento_pk PRIMARY KEY (idevento);


--
-- TOC entry 3219 (class 2606 OID 131121)
-- Name: localidad localidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (codigo, idevento, idseccion);


--
-- TOC entry 3207 (class 2606 OID 122917)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (idmenu);


--
-- TOC entry 3209 (class 2606 OID 122919)
-- Name: menuxperfil menuxperfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT menuxperfil_pkey PRIMARY KEY (idperfil, idmenu);


--
-- TOC entry 3211 (class 2606 OID 122921)
-- Name: perfil perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);


--
-- TOC entry 3213 (class 2606 OID 122923)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (idpersona);


--
-- TOC entry 3217 (class 2606 OID 131114)
-- Name: seccion seccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_pkey PRIMARY KEY (idevento, idseccion);


--
-- TOC entry 3215 (class 2606 OID 122925)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codusr);


--
-- TOC entry 3220 (class 2606 OID 122926)
-- Name: menuxperfil id_menuxperfil_id_menu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_menu FOREIGN KEY (idmenu) REFERENCES public.menu(idmenu) NOT VALID;


--
-- TOC entry 3221 (class 2606 OID 122931)
-- Name: menuxperfil id_menuxperfil_id_perfil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_perfil FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) NOT VALID;


--
-- TOC entry 3222 (class 2606 OID 122936)
-- Name: usuario id_usuario_id_perfil_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_perfil_fk FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) ON UPDATE SET NULL ON DELETE SET NULL NOT VALID;


--
-- TOC entry 3223 (class 2606 OID 122941)
-- Name: usuario id_usuario_id_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 3224 (class 2606 OID 131122)
-- Name: seccion seccion_evento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_evento_fk FOREIGN KEY (idevento) REFERENCES public.evento(idevento) NOT VALID;


-- Completed on 2023-10-29 17:54:14

--
-- PostgreSQL database dump complete
--

