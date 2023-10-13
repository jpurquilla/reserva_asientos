CREATE TABLE evento (
                               estado integer,
                               nombre character varying(255),
                               descripcion character varying(255),
                               foto bytea,
                               horafin time(6) without time zone,
                               horainicio time(6) without time zone,
                               fecha date,
                               idevento integer NOT NULL
);


ALTER TABLE evento OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 106549)
-- Name: evento_idevento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE evento_idevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento_idevento_seq OWNER TO postgres;

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 221
-- Name: evento_idevento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE evento_idevento_seq OWNED BY evento.idevento;


--
-- TOC entry 219 (class 1259 OID 106522)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE menu (
                             idmenu integer NOT NULL,
                             url character varying,
                             nombre character varying NOT NULL
);


ALTER TABLE menu OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 106529)
-- Name: menuxperfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE menuxperfil (
                                    idperfil integer NOT NULL,
                                    idmenu integer NOT NULL
);


ALTER TABLE menuxperfil OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 106510)
-- Name: perfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE perfil (
                               idperfil integer NOT NULL,
                               descripcion character varying NOT NULL
);


ALTER TABLE perfil OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 106497)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE persona (
                                idpersona integer NOT NULL,
                                nombres character varying NOT NULL,
                                apellidos character varying NOT NULL,
                                dui character varying,
                                email character varying,
                                telefono character varying
);


ALTER TABLE persona OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 106496)
-- Name: persona_idpersona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE persona_idpersona_seq OWNER TO postgres;

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 216
-- Name: persona_idpersona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE persona_idpersona_seq OWNED BY persona.idpersona;


--
-- TOC entry 214 (class 1259 OID 81932)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
                                codusr character varying(255) NOT NULL,
                                password character varying(255) NOT NULL,
                                fechacrea timestamp(6) without time zone NOT NULL,
                                idpersona integer,
                                idperfil integer
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 3194 (class 2604 OID 106550)
-- Name: evento idevento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY evento ALTER COLUMN idevento SET DEFAULT nextval('evento_idevento_seq'::regclass);


--
-- TOC entry 3195 (class 2604 OID 106500)
-- Name: persona idpersona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona ALTER COLUMN idpersona SET DEFAULT nextval('persona_idpersona_seq'::regclass);


--
-- TOC entry 3199 (class 2606 OID 106557)
-- Name: evento idevento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY evento
    ADD CONSTRAINT idevento_pk PRIMARY KEY (idevento);


--
-- TOC entry 3205 (class 2606 OID 106528)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (idmenu);


--
-- TOC entry 3207 (class 2606 OID 106533)
-- Name: menuxperfil menuxperfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY menuxperfil
    ADD CONSTRAINT menuxperfil_pkey PRIMARY KEY (idperfil, idmenu);


--
-- TOC entry 3203 (class 2606 OID 106516)
-- Name: perfil perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);


--
-- TOC entry 3201 (class 2606 OID 106504)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (idpersona);


--
-- TOC entry 3197 (class 2606 OID 81938)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codusr);


--
-- TOC entry 3210 (class 2606 OID 106539)
-- Name: menuxperfil id_menuxperfil_id_menu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_menu FOREIGN KEY (idmenu) REFERENCES menu(idmenu) NOT VALID;


--
-- TOC entry 3211 (class 2606 OID 106534)
-- Name: menuxperfil id_menuxperfil_id_perfil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_perfil FOREIGN KEY (idperfil) REFERENCES perfil(idperfil) NOT VALID;


--
-- TOC entry 3208 (class 2606 OID 106517)
-- Name: usuario id_usuario_id_perfil_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT id_usuario_id_perfil_fk FOREIGN KEY (idperfil) REFERENCES perfil(idperfil) ON UPDATE SET NULL ON DELETE SET NULL NOT VALID;


--
-- TOC entry 3209 (class 2606 OID 106505)
-- Name: usuario id_usuario_id_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT id_usuario_id_persona_fk FOREIGN KEY (idpersona) REFERENCES persona(idpersona) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;