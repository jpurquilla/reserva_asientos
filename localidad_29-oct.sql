--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-10-29 21:37:29

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
-- TOC entry 3338 (class 0 OID 131115)
-- Dependencies: 223
-- Data for Name: localidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.localidad VALUES ('UP1', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP2', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP3', 1, 1, 10);
INSERT INTO public.localidad VALUES ('P1', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P3', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P4', 1, 2, 10);
INSERT INTO public.localidad VALUES ('VIP1', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP2', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP3', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP4', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP5', 1, 3, 10);
INSERT INTO public.localidad VALUES ('G1', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G2', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G3', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G5', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G6', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G4', 1, 4, 30);
INSERT INTO public.localidad VALUES ('P2', 1, 2, 30);
INSERT INTO public.localidad VALUES ('UP4', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP5', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP6', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP7', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP8', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP9', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP10', 1, 1, 10);
INSERT INTO public.localidad VALUES ('P5', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P6', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P7', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P8', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P9', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P10', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P11', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P12', 1, 2, 10);
INSERT INTO public.localidad VALUES ('VIP6', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP7', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP8', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP9', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP10', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP11', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP12', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP13', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP14', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP15', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP16', 1, 3, 10);
INSERT INTO public.localidad VALUES ('G7', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G8', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G9', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G10', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G11', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G12', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G13', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G14', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G15', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G16', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G17', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G18', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G19', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G20', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G21', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G22', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G23', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G24', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G25', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G26', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G27', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G28', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G29', 1, 4, 10);
INSERT INTO public.localidad VALUES ('G30', 1, 4, 10);
INSERT INTO public.localidad VALUES ('UP11', 1, 1, 10);
INSERT INTO public.localidad VALUES ('UP12', 1, 1, 10);
INSERT INTO public.localidad VALUES ('P13', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P14', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P15', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P16', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P17', 1, 2, 10);
INSERT INTO public.localidad VALUES ('P18', 1, 2, 10);
INSERT INTO public.localidad VALUES ('VIP17', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP18', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP19', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP20', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP21', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP22', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP23', 1, 3, 10);
INSERT INTO public.localidad VALUES ('VIP24', 1, 3, 10);


--
-- TOC entry 3195 (class 2606 OID 131121)
-- Name: localidad localidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (codigo, idevento, idseccion);


-- Completed on 2023-10-29 21:37:29

--
-- PostgreSQL database dump complete
--

