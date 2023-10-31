--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-10-29 21:38:15

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
-- TOC entry 3339 (class 0 OID 131110)
-- Dependencies: 222
-- Data for Name: seccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.seccion VALUES (1, 1, 'Ultra Premium', 100.00);
INSERT INTO public.seccion VALUES (1, 2, 'Premium', 75.00);
INSERT INTO public.seccion VALUES (1, 3, 'VIP', 50.00);
INSERT INTO public.seccion VALUES (1, 4, 'General', 25.00);


--
-- TOC entry 3195 (class 2606 OID 131114)
-- Name: seccion seccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_pkey PRIMARY KEY (idevento, idseccion);


--
-- TOC entry 3196 (class 2606 OID 131122)
-- Name: seccion seccion_evento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_evento_fk FOREIGN KEY (idevento) REFERENCES public.evento(idevento) NOT VALID;


-- Completed on 2023-10-29 21:38:16

--
-- PostgreSQL database dump complete
--

