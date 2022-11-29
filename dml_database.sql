------------------PERSONA
DROP TABLE IF EXISTS public.persona;

CREATE TABLE IF NOT EXISTS public.persona
(
    cedula character varying(10) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(100) COLLATE pg_catalog."default",
    correo character varying(100) COLLATE pg_catalog."default",
    direccion character varying(100) COLLATE pg_catalog."default",
    fnacimiento date,
    nombres character varying(100) COLLATE pg_catalog."default",
    telefono character varying(10) COLLATE pg_catalog."default",
    vacunado integer NOT NULL,
    CONSTRAINT persona_pkey PRIMARY KEY (cedula)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persona
    OWNER to postgres;

-----------------VACUNA
DROP TABLE IF EXISTS public.vacuna;

CREATE TABLE IF NOT EXISTS public.vacuna
(
    id bigint NOT NULL,
    dosis integer NOT NULL,
    fvacunacion date,
    tipo_vacuna character varying(50) COLLATE pg_catalog."default",
    cedula character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vacuna_pkey PRIMARY KEY (id),
    CONSTRAINT fksfdewi8ymy0t6s49g2s3bwqlg FOREIGN KEY (cedula)
        REFERENCES public.persona (cedula) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vacuna
    OWNER to postgres;

-----------------ROL

DROP TABLE IF EXISTS public.rol;

CREATE TABLE IF NOT EXISTS public.rol
(
    id bigint NOT NULL,
    nombre_rol character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT rol_pkey PRIMARY KEY (id),
    CONSTRAINT uk_l0qdsam7tunbtmxcmeeyfcifk UNIQUE (nombre_rol)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rol
    OWNER to postgres;

-----------------USUARIO

DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL,
    pass character varying(20) COLLATE pg_catalog."default",
    username character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT uk_863n1y3x0jalatoir4325ehal UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;

------------------USUARIOS-ROLES
DROP TABLE IF EXISTS public.usuarios_roles;

CREATE TABLE IF NOT EXISTS public.usuarios_roles
(
    usuario_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT ukqjaspm7473pnu9y4jxhrds8r2 UNIQUE (usuario_id, role_id),
    CONSTRAINT fkebiaxjbamgu326glxo1fbysuh FOREIGN KEY (usuario_id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkg2v3l7btkyshkodfxwhxdoehm FOREIGN KEY (role_id)
        REFERENCES public.rol (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios_roles
    OWNER to postgres;

----------------------------------------------------