--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-10-12 11:26:58

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
-- TOC entry 215 (class 1259 OID 90112)
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
-- TOC entry 221 (class 1259 OID 106549)
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
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 221
-- Name: evento_idevento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evento_idevento_seq OWNED BY public.evento.idevento;


--
-- TOC entry 219 (class 1259 OID 106522)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    idmenu integer NOT NULL,
    url character varying,
    nombre character varying NOT NULL
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 106529)
-- Name: menuxperfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuxperfil (
    idperfil integer NOT NULL,
    idmenu integer NOT NULL
);


ALTER TABLE public.menuxperfil OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 106510)
-- Name: perfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.perfil (
    idperfil integer NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.perfil OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 106497)
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
-- TOC entry 216 (class 1259 OID 106496)
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
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 216
-- Name: persona_idpersona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_idpersona_seq OWNED BY public.persona.idpersona;


--
-- TOC entry 214 (class 1259 OID 81932)
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
-- TOC entry 3194 (class 2604 OID 106550)
-- Name: evento idevento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evento ALTER COLUMN idevento SET DEFAULT nextval('public.evento_idevento_seq'::regclass);


--
-- TOC entry 3195 (class 2604 OID 106500)
-- Name: persona idpersona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);


--
-- TOC entry 3199 (class 2606 OID 106557)
-- Name: evento idevento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idevento_pk PRIMARY KEY (idevento);


--
-- TOC entry 3205 (class 2606 OID 106528)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (idmenu);


--
-- TOC entry 3207 (class 2606 OID 106533)
-- Name: menuxperfil menuxperfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT menuxperfil_pkey PRIMARY KEY (idperfil, idmenu);


--
-- TOC entry 3203 (class 2606 OID 106516)
-- Name: perfil perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);


--
-- TOC entry 3201 (class 2606 OID 106504)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (idpersona);


--
-- TOC entry 3197 (class 2606 OID 81938)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codusr);


--
-- TOC entry 3210 (class 2606 OID 106539)
-- Name: menuxperfil id_menuxperfil_id_menu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_menu FOREIGN KEY (idmenu) REFERENCES public.menu(idmenu) NOT VALID;


--
-- TOC entry 3211 (class 2606 OID 106534)
-- Name: menuxperfil id_menuxperfil_id_perfil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_perfil FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) NOT VALID;


--
-- TOC entry 3208 (class 2606 OID 106517)
-- Name: usuario id_usuario_id_perfil_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_perfil_fk FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) ON UPDATE SET NULL ON DELETE SET NULL NOT VALID;


--
-- TOC entry 3209 (class 2606 OID 106505)
-- Name: usuario id_usuario_id_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


-- Completed on 2023-10-12 11:26:59

--
-- PostgreSQL database dump complete
--

