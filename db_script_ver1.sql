PGDMP         5            	    {            proyecto_igf_1    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    73728    proyecto_igf_1    DATABASE     �   CREATE DATABASE proyecto_igf_1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE proyecto_igf_1;
                postgres    false            �            1259    90112    evento    TABLE       CREATE TABLE public.evento (
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
       public         heap    postgres    false            �            1259    106549    evento_idevento_seq    SEQUENCE     �   CREATE SEQUENCE public.evento_idevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.evento_idevento_seq;
       public          postgres    false    215                        0    0    evento_idevento_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.evento_idevento_seq OWNED BY public.evento.idevento;
          public          postgres    false    221            �            1259    106522    menu    TABLE     |   CREATE TABLE public.menu (
    idmenu integer NOT NULL,
    url character varying,
    nombre character varying NOT NULL
);
    DROP TABLE public.menu;
       public         heap    postgres    false            �            1259    106529    menuxperfil    TABLE     `   CREATE TABLE public.menuxperfil (
    idperfil integer NOT NULL,
    idmenu integer NOT NULL
);
    DROP TABLE public.menuxperfil;
       public         heap    postgres    false            �            1259    106510    perfil    TABLE     j   CREATE TABLE public.perfil (
    idperfil integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.perfil;
       public         heap    postgres    false            �            1259    106497    persona    TABLE     �   CREATE TABLE public.persona (
    idpersona integer NOT NULL,
    nombres character varying NOT NULL,
    apellidos character varying NOT NULL,
    dui character varying,
    email character varying,
    telefono character varying
);
    DROP TABLE public.persona;
       public         heap    postgres    false            �            1259    106496    persona_idpersona_seq    SEQUENCE     �   CREATE SEQUENCE public.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.persona_idpersona_seq;
       public          postgres    false    217            !           0    0    persona_idpersona_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.persona_idpersona_seq OWNED BY public.persona.idpersona;
          public          postgres    false    216            �            1259    81932    usuario    TABLE     �   CREATE TABLE public.usuario (
    codusr character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    fechacrea timestamp(6) without time zone NOT NULL,
    idpersona integer,
    idperfil integer
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            z           2604    106550    evento idevento    DEFAULT     r   ALTER TABLE ONLY public.evento ALTER COLUMN idevento SET DEFAULT nextval('public.evento_idevento_seq'::regclass);
 >   ALTER TABLE public.evento ALTER COLUMN idevento DROP DEFAULT;
       public          postgres    false    221    215            {           2604    106500    persona idpersona    DEFAULT     v   ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);
 @   ALTER TABLE public.persona ALTER COLUMN idpersona DROP DEFAULT;
       public          postgres    false    216    217    217                       2606    106557    evento idevento_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idevento_pk PRIMARY KEY (idevento);
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT idevento_pk;
       public            postgres    false    215            �           2606    106528    menu menu_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (idmenu);
 8   ALTER TABLE ONLY public.menu DROP CONSTRAINT menu_pkey;
       public            postgres    false    219            �           2606    106533    menuxperfil menuxperfil_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT menuxperfil_pkey PRIMARY KEY (idperfil, idmenu);
 F   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT menuxperfil_pkey;
       public            postgres    false    220    220            �           2606    106516    perfil perfil_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public            postgres    false    218            �           2606    106504    persona persona_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (idpersona);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    217            }           2606    81938    usuario usuario_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codusr);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    214            �           2606    106539 "   menuxperfil id_menuxperfil_id_menu    FK CONSTRAINT     �   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_menu FOREIGN KEY (idmenu) REFERENCES public.menu(idmenu) NOT VALID;
 L   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT id_menuxperfil_id_menu;
       public          postgres    false    219    3205    220            �           2606    106534 $   menuxperfil id_menuxperfil_id_perfil    FK CONSTRAINT     �   ALTER TABLE ONLY public.menuxperfil
    ADD CONSTRAINT id_menuxperfil_id_perfil FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) NOT VALID;
 N   ALTER TABLE ONLY public.menuxperfil DROP CONSTRAINT id_menuxperfil_id_perfil;
       public          postgres    false    3203    220    218            �           2606    106517    usuario id_usuario_id_perfil_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_perfil_fk FOREIGN KEY (idperfil) REFERENCES public.perfil(idperfil) ON UPDATE SET NULL ON DELETE SET NULL NOT VALID;
 I   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id_usuario_id_perfil_fk;
       public          postgres    false    214    3203    218            �           2606    106505     usuario id_usuario_id_persona_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario_id_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 J   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id_usuario_id_persona_fk;
       public          postgres    false    3201    214    217           