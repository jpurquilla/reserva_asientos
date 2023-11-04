PGDMP                     
    {            reserva_asientos    15.2    15.2 4    E           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            F           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            G           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            H           1262    73728    reserva_asientos    DATABASE     �   CREATE DATABASE reserva_asientos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
     DROP DATABASE reserva_asientos;
                postgres    false            �            1259    122882    evento    TABLE       CREATE TABLE public.evento (
    estado integer,
    nombre character varying(255),
    descripcion character varying(255),
    foto bytea,
    horafin time(6) without time zone,
    horainicio time(6) without time zone,
    fecha date,
    idevento integer NOT NULL
);
    DROP TABLE public.evento;
       public         heap    postgres    false            �            1259    122887    evento_idevento_seq    SEQUENCE     �   CREATE SEQUENCE public.evento_idevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.evento_idevento_seq;
       public          postgres    false    214            I           0    0    evento_idevento_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.evento_idevento_seq OWNED BY public.evento.idevento;
          public          postgres    false    215            �            1259    131115 	   localidad    TABLE     �   CREATE TABLE public.localidad (
    codigo character varying NOT NULL,
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    estado integer NOT NULL
);
    DROP TABLE public.localidad;
       public         heap    postgres    false            �            1259    122888    menu    TABLE     |   CREATE TABLE public.menu (
    idmenu integer NOT NULL,
    url character varying,
    nombre character varying NOT NULL
);
    DROP TABLE public.menu;
       public         heap    postgres    false            �            1259    122893    menuxperfil    TABLE     `   CREATE TABLE public.menuxperfil (
    idperfil integer NOT NULL,
    idmenu integer NOT NULL
);
    DROP TABLE public.menuxperfil;
       public         heap    postgres    false            �            1259    122896    perfil    TABLE     j   CREATE TABLE public.perfil (
    idperfil integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.perfil;
       public         heap    postgres    false            �            1259    122901    persona    TABLE     �   CREATE TABLE public.persona (
    idpersona integer NOT NULL,
    nombres character varying NOT NULL,
    apellidos character varying NOT NULL,
    dui character varying,
    email character varying,
    telefono character varying
);
    DROP TABLE public.persona;
       public         heap    postgres    false            �            1259    122906    persona_idpersona_seq    SEQUENCE     �   CREATE SEQUENCE public.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.persona_idpersona_seq;
       public          postgres    false    219            J           0    0    persona_idpersona_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.persona_idpersona_seq OWNED BY public.persona.idpersona;
          public          postgres    false    220            �            1259    139265    reserva    TABLE     �   CREATE TABLE public.reserva (
    idreserva integer NOT NULL,
    idpersona integer NOT NULL,
    estado integer NOT NULL,
    total numeric(14,2),
    fecha date
);
    DROP TABLE public.reserva;
       public         heap    postgres    false            �            1259    139264    reserva_idreserva_seq    SEQUENCE     �   CREATE SEQUENCE public.reserva_idreserva_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.reserva_idreserva_seq;
       public          postgres    false    225            K           0    0    reserva_idreserva_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.reserva_idreserva_seq OWNED BY public.reserva.idreserva;
          public          postgres    false    224            �            1259    139286    reservadetalle    TABLE     �   CREATE TABLE public.reservadetalle (
    idreserva integer NOT NULL,
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    codigo character varying NOT NULL
);
 "   DROP TABLE public.reservadetalle;
       public         heap    postgres    false            �            1259    131110    seccion    TABLE     �   CREATE TABLE public.seccion (
    idevento integer NOT NULL,
    idseccion integer NOT NULL,
    nombre character varying(50) NOT NULL,
    precio numeric(14,2) NOT NULL
);
    DROP TABLE public.seccion;
       public         heap    postgres    false            �            1259    122907    usuario    TABLE     �   CREATE TABLE public.usuario (
    codusr character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    fechacrea timestamp(6) without time zone NOT NULL,
    idpersona integer,
    idperfil integer
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �           2604    122912    evento idevento    DEFAULT     r   ALTER TABLE ONLY public.evento ALTER COLUMN idevento SET DEFAULT nextval('public.evento_idevento_seq'::regclass);
 >   ALTER TABLE public.evento ALTER COLUMN idevento DROP DEFAULT;
       public          postgres    false    215    214            �           2604    122913    persona idpersona    DEFAULT     v   ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);
 @   ALTER TABLE public.persona ALTER COLUMN idpersona DROP DEFAULT;
       public          postgres    false    220    219            �           2604    139268    reserva idreserva    DEFAULT     v   ALTER TABLE ONLY public.reserva ALTER COLUMN idreserva SET DEFAULT nextval('public.reserva_idreserva_seq'::regclass);
 @   ALTER TABLE public.reserva ALTER COLUMN idreserva DROP DEFAULT;
       public          postgres    false    224    225    225            6          0    122882    evento 
   TABLE DATA           i   COPY public.evento (estado, nombre, descripcion, foto, horafin, horainicio, fecha, idevento) FROM stdin;
    public          postgres    false    214   J<       ?          0    131115 	   localidad 
   TABLE DATA           H   COPY public.localidad (codigo, idevento, idseccion, estado) FROM stdin;
    public          postgres    false    223   �<       8          0    122888    menu 
   TABLE DATA           3   COPY public.menu (idmenu, url, nombre) FROM stdin;
    public          postgres    false    216   �=       9          0    122893    menuxperfil 
   TABLE DATA           7   COPY public.menuxperfil (idperfil, idmenu) FROM stdin;
    public          postgres    false    217   �=       :          0    122896    perfil 
   TABLE DATA           7   COPY public.perfil (idperfil, descripcion) FROM stdin;
    public          postgres    false    218   >       ;          0    122901    persona 
   TABLE DATA           V   COPY public.persona (idpersona, nombres, apellidos, dui, email, telefono) FROM stdin;
    public          postgres    false    219   0>       A          0    139265    reserva 
   TABLE DATA           M   COPY public.reserva (idreserva, idpersona, estado, total, fecha) FROM stdin;
    public          postgres    false    225   �>       B          0    139286    reservadetalle 
   TABLE DATA           P   COPY public.reservadetalle (idreserva, idevento, idseccion, codigo) FROM stdin;
    public          postgres    false    226   �?       >          0    131110    seccion 
   TABLE DATA           F   COPY public.seccion (idevento, idseccion, nombre, precio) FROM stdin;
    public          postgres    false    222   �?       =          0    122907    usuario 
   TABLE DATA           S   COPY public.usuario (codusr, password, fechacrea, idpersona, idperfil) FROM stdin;
    public          postgres    false    221   5@       L           0    0    evento_idevento_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.evento_idevento_seq', 1, false);
          public          postgres    false    215            M           0    0    persona_idpersona_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.persona_idpersona_seq', 1, true);
          public          postgres    false    220            N           0    0    reserva_idreserva_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.reserva_idreserva_seq', 185, true);
          public          postgres    false    224            �           2606    122915    evento idevento_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idevento_pk PRIMARY KEY (idevento);
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT idevento_pk;
       public            postgres    false    214            �           2606    131121    localidad localidad_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (codigo, idevento, idseccion);
 B   ALTER TABLE ONLY public.localidad DROP CONSTRAINT localidad_pkey;
       public            postgres    false    223    223    223            �           2606    122917    menu menu_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (idmenu);
 8   ALTER TABLE ONLY public.menu DROP CONSTRAINT menu_pkey;
       public            postgres    false    216            �           2606    122919    menuxperfil menuxperfil_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT menuxperfil_pkey PRIMARY KEY (idperfil, idmenu);
 F   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT menuxperfil_pkey;
       public            postgres    false    217    217            �           2606    122921    perfil perfil_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public            postgres    false    218            �           2606    122923    persona persona_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (idpersona);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    219            �           2606    139270    reserva reserva_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (idreserva);
 >   ALTER TABLE ONLY public.reserva DROP CONSTRAINT reserva_pkey;
       public            postgres    false    225            �           2606    139292 "   reservadetalle reservadetalle_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.reservadetalle
    ADD CONSTRAINT reservadetalle_pkey PRIMARY KEY (idreserva, idevento, idseccion, codigo);
 L   ALTER TABLE ONLY public.reservadetalle DROP CONSTRAINT reservadetalle_pkey;
       public            postgres    false    226    226    226    226            �           2606    131114    seccion seccion_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_pkey PRIMARY KEY (idevento, idseccion);
 >   ALTER TABLE ONLY public.seccion DROP CONSTRAINT seccion_pkey;
       public            postgres    false    222    222            �           2606    122925    usuario usuario_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codusr);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    221            �           2606    122926 "   menuxperfil id_menuxperfil_id_menu    FK CONSTRAINT     �   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_menu FOREIGN KEY (idmenu) REFERENCES public.menu(idmenu) NOT VALID;
 L   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT id_menuxperfil_id_menu;
       public          postgres    false    3217    217    216            �           2606    122931 $   menuxperfil id_menuxperfil_id_perfil    FK CONSTRAINT     �   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_perfil FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) NOT VALID;
 N   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT id_menuxperfil_id_perfil;
       public          postgres    false    3221    217    218            �           2606    122936    usuario id_usuario_id_perfil_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_perfil_fk FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) ON UPDATE SET NULL ON DELETE SET NULL NOT VALID;
 I   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id_usuario_id_perfil_fk;
       public          postgres    false    221    218    3221            �           2606    122941     usuario id_usuario_id_persona_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 J   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id_usuario_id_persona_fk;
       public          postgres    false    221    219    3223            �           2606    139271    reserva persona_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona);
 <   ALTER TABLE ONLY public.reserva DROP CONSTRAINT persona_fk;
       public          postgres    false    225    3223    219            �           2606    131122    seccion seccion_evento_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_evento_fk FOREIGN KEY (idevento) REFERENCES public.evento(idevento) NOT VALID;
 C   ALTER TABLE ONLY public.seccion DROP CONSTRAINT seccion_evento_fk;
       public          postgres    false    214    222    3215            6   C   x�34�t-K�+�W(I-.�t-.IUH-V(̓�c�8ͭ�����0202�54�5��4����� Ü      ?   �   x�U�=� ���0}�@~N���B����X���-W,XlIa�D?mu[z;��c z���?�;�=hw���/���o�|[Uf��&��p�\��4Ȝ���&UdmX�Kn��x�r���Ñ��H:'P��H'1:���?�L�vL�f���]�>���C�G���j�#�� 3$"?^�Uߪ6�X ��c1c1s)1����}����5uC��Q����D<:����n��c��u]���      8   0   x�34�LL����,.)JL�/�/HLO5��M�+U((*MMJ����� '�      9      x�34�44������ 
+~      :      x�34�tL����,.)JL�/����� O�n      ;   @   x�3��*M�SHL���-*,���I�4 ]ά�R��Cznbf�^r~.�����.������� ��:      A   
  x�uֻm@D�X�E�������b�x�&�syt=�׻��z��W���|?�G�����)��7�@��}�tx?�^x/�����{��^x/�)�S�@N��:u
��)�S�G�H�#y$��<�G�Hޒ��-yKޒ��-yKޒ��C�!��|H>$�ɇ�C�!��|J>%��Oɧ�S�)��|J�$_�/ɗ�K�%��|I�$_�oɷ�[�-��|K�%ߒoɷ�G�#���H~$?�ɏ�k�^�[�آ�m�h�E����|>K���      B   6   x�37�4�4�0��27�0��,K.sS ˘3�3�А����2@0�b���� �(K      >   E   x�3�4��))JT(J��,��440�30�2�4�	��BD�9�<8M��&��y�E�9�F`�=... #N_      =   3   x��*(-*,���I�LL����4202�54�54P00�#NCNC�=... Q�T     