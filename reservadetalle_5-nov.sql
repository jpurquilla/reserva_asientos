--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-03 17:42:56

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
-- TOC entry 226 (class 1259 OID 139286)
-- Name: reservadetalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservadetalle (
    idreserva integer NOT NULL,
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    codigo character varying NOT NULL
);


ALTER TABLE public.reservadetalle OWNER TO postgres;

--
-- TOC entry 3345 (class 0 OID 139286)
-- Dependencies: 226
-- Data for Name: reservadetalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservadetalle (idreserva, idevento, idseccion, codigo) FROM stdin;
70	1	2	P18
72	1	2	P3
72	1	2	P9
75	1	3	VIP11
77	1	2	P1
77	1	2	P10
77	1	2	P11
208	1	3	VIP14
209	1	3	VIP12
209	1	4	G12
209	1	4	G13
209	1	4	G14
210	1	3	VIP11
\.


--
-- TOC entry 3202 (class 2606 OID 139292)
-- Name: reservadetalle reservadetalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservadetalle
    ADD CONSTRAINT reservadetalle_pkey PRIMARY KEY (idreserva, idevento, idseccion, codigo);


-- Completed on 2023-11-03 17:42:56

--
-- PostgreSQL database dump complete
--

