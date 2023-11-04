--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-03 17:43:35

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

--
-- TOC entry 3345 (class 0 OID 122882)
-- Dependencies: 214
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evento (estado, nombre, descripcion, foto, horafin, horainicio, fecha, idevento) FROM stdin;
10	Evento test	Este es un test	\N	17:00:00	15:00:00	2023-10-29	1
\.


--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 215
-- Name: evento_idevento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evento_idevento_seq', 1, false);


-- Completed on 2023-11-03 17:43:35

--
-- PostgreSQL database dump complete
--

