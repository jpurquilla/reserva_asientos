--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-03 17:42:39

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
-- TOC entry 225 (class 1259 OID 139265)
-- Name: reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reserva (
    idreserva integer NOT NULL,
    idpersona integer NOT NULL,
    estado integer NOT NULL,
    total numeric(14,2),
    fecha date
);


ALTER TABLE public.reserva OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 139264)
-- Name: reserva_idreserva_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reserva_idreserva_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reserva_idreserva_seq OWNER TO postgres;

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 224
-- Name: reserva_idreserva_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reserva_idreserva_seq OWNED BY public.reserva.idreserva;


--
-- TOC entry 3201 (class 2604 OID 139268)
-- Name: reserva idreserva; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva ALTER COLUMN idreserva SET DEFAULT nextval('public.reserva_idreserva_seq'::regclass);


--
-- TOC entry 3348 (class 0 OID 139265)
-- Dependencies: 225
-- Data for Name: reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reserva (idreserva, idpersona, estado, total, fecha) FROM stdin;
77	1	20	225.00	2023-11-03
78	1	10	0.00	2023-11-03
79	1	10	0.00	2023-11-03
80	1	10	0.00	2023-11-03
81	1	10	0.00	2023-11-03
82	1	10	0.00	2023-11-03
83	1	10	0.00	2023-11-03
84	1	10	0.00	2023-11-03
85	1	10	0.00	2023-11-03
86	1	10	0.00	2023-11-03
87	1	10	0.00	2023-11-03
88	1	10	0.00	2023-11-03
89	1	10	0.00	2023-11-03
90	1	10	0.00	2023-11-03
91	1	10	0.00	2023-11-03
92	1	10	0.00	2023-11-03
93	1	10	0.00	2023-11-03
94	1	10	0.00	2023-11-03
95	1	10	0.00	2023-11-03
96	1	10	0.00	2023-11-03
97	1	10	0.00	2023-11-03
98	1	10	0.00	2023-11-03
99	1	10	0.00	2023-11-03
100	1	10	0.00	2023-11-03
101	1	10	0.00	2023-11-03
102	1	10	0.00	2023-11-03
103	1	10	0.00	2023-11-03
104	1	10	0.00	2023-11-03
105	1	10	0.00	2023-11-03
106	1	10	0.00	2023-11-03
107	1	10	0.00	2023-11-03
108	1	10	0.00	2023-11-03
109	1	10	0.00	2023-11-03
110	1	10	0.00	2023-11-03
111	1	10	0.00	2023-11-03
112	1	10	0.00	2023-11-03
113	1	10	0.00	2023-11-03
114	1	10	0.00	2023-11-03
115	1	10	0.00	2023-11-03
116	1	10	0.00	2023-11-03
117	1	10	0.00	2023-11-03
118	1	10	0.00	2023-11-03
119	1	10	0.00	2023-11-03
120	1	10	0.00	2023-11-03
121	1	10	0.00	2023-11-03
122	1	10	0.00	2023-11-03
123	1	10	0.00	2023-11-03
124	1	10	0.00	2023-11-03
125	1	10	0.00	2023-11-03
126	1	10	0.00	2023-11-03
127	1	10	0.00	2023-11-03
128	1	10	0.00	2023-11-03
129	1	10	0.00	2023-11-03
130	1	10	0.00	2023-11-03
131	1	10	0.00	2023-11-03
132	1	10	0.00	2023-11-03
133	1	10	0.00	2023-11-03
134	1	10	0.00	2023-11-03
135	1	10	0.00	2023-11-03
136	1	10	0.00	2023-11-03
137	1	10	0.00	2023-11-03
138	1	10	0.00	2023-11-03
139	1	10	0.00	2023-11-03
140	1	10	0.00	2023-11-03
141	1	10	0.00	2023-11-03
142	1	10	0.00	2023-11-03
143	1	10	0.00	2023-11-03
144	1	10	0.00	2023-11-03
145	1	10	0.00	2023-11-03
146	1	10	0.00	2023-11-03
147	1	10	0.00	2023-11-03
148	1	10	0.00	2023-11-03
149	1	10	0.00	2023-11-03
150	1	10	0.00	2023-11-03
151	1	10	0.00	2023-11-03
152	1	10	0.00	2023-11-03
153	1	10	0.00	2023-11-03
154	1	10	0.00	2023-11-03
155	1	10	0.00	2023-11-03
156	1	10	0.00	2023-11-03
157	1	10	0.00	2023-11-03
158	1	10	0.00	2023-11-03
159	1	10	0.00	2023-11-03
160	1	10	0.00	2023-11-03
161	1	10	0.00	2023-11-03
162	1	10	0.00	2023-11-03
163	1	10	0.00	2023-11-03
164	1	10	0.00	2023-11-03
165	1	10	0.00	2023-11-03
166	1	10	0.00	2023-11-03
167	1	10	0.00	2023-11-03
168	1	10	0.00	2023-11-03
169	1	10	0.00	2023-11-03
170	1	10	0.00	2023-11-03
171	1	10	0.00	2023-11-03
172	1	10	0.00	2023-11-03
173	1	10	0.00	2023-11-03
174	1	10	0.00	2023-11-03
175	1	10	0.00	2023-11-03
176	1	10	0.00	2023-11-03
177	1	10	0.00	2023-11-03
178	1	10	0.00	2023-11-03
179	1	10	0.00	2023-11-03
180	1	10	0.00	2023-11-03
181	1	10	0.00	2023-11-03
182	1	10	0.00	2023-11-03
183	1	10	0.00	2023-11-03
184	1	10	0.00	2023-11-03
185	1	10	0.00	2023-11-03
186	1	10	0.00	2023-11-03
187	1	10	0.00	2023-11-03
188	1	10	0.00	2023-11-03
189	1	10	0.00	2023-11-03
190	1	10	0.00	2023-11-03
191	1	10	0.00	2023-11-03
192	1	10	0.00	2023-11-03
193	1	10	0.00	2023-11-03
194	1	10	0.00	2023-11-03
195	1	10	0.00	2023-11-03
196	1	10	0.00	2023-11-03
197	1	10	0.00	2023-11-03
198	1	10	0.00	2023-11-03
199	1	10	0.00	2023-11-03
200	1	10	0.00	2023-11-03
201	1	10	0.00	2023-11-03
202	1	10	0.00	2023-11-03
203	1	10	0.00	2023-11-03
204	1	20	100.00	2023-11-03
205	1	10	0.00	2023-11-03
206	1	20	25.00	2023-11-03
207	1	20	25.00	2023-11-03
208	1	20	50.00	2023-11-03
210	1	20	50.00	2023-11-03
211	1	10	0.00	2023-11-03
209	1	20	75.00	2023-11-03
212	1	10	0.00	2023-11-03
213	1	10	0.00	2023-11-03
214	1	10	0.00	2023-11-03
215	1	10	0.00	2023-11-03
216	1	10	0.00	2023-11-03
217	1	10	0.00	2023-11-03
218	1	10	0.00	2023-11-03
219	1	10	0.00	2023-11-03
220	1	10	0.00	2023-11-03
221	1	10	0.00	2023-11-03
222	1	10	0.00	2023-11-03
223	1	10	0.00	2023-11-03
224	1	10	0.00	2023-11-03
225	1	10	0.00	2023-11-03
226	1	10	0.00	2023-11-03
227	1	10	0.00	2023-11-03
228	1	10	0.00	2023-11-03
229	1	10	0.00	2023-11-03
\.


--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 224
-- Name: reserva_idreserva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reserva_idreserva_seq', 229, true);


--
-- TOC entry 3203 (class 2606 OID 139270)
-- Name: reserva reserva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (idreserva);


--
-- TOC entry 3204 (class 2606 OID 139271)
-- Name: reserva persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona);


-- Completed on 2023-11-03 17:42:40

--
-- PostgreSQL database dump complete
--

