CREATE TABLE public.direction
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    departmen text COLLATE pg_catalog."default",
    specialization text COLLATE pg_catalog."default",
    CONSTRAINT direction_pkey PRIMARY KEY (id)
)

CREATE TABLE public.educator
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    first_name character(20) COLLATE pg_catalog."default",
    secound_name character(20) COLLATE pg_catalog."default",
    patronymic character(20) COLLATE pg_catalog."default",
    direction_id integer,
    CONSTRAINT educator_pkey PRIMARY KEY (id)
)

CREATE TABLE public.student
(
    id integer NOT NULL DEFAULT nextval('student_id_seq'::regclass),
    first_name character(20) COLLATE pg_catalog."default" NOT NULL,
    secound_name character(20) COLLATE pg_catalog."default" NOT NULL,
    patronymic character(20) COLLATE pg_catalog."default",
    team_id integer,
    CONSTRAINT student_data_pkey PRIMARY KEY (id),
    CONSTRAINT team_fk FOREIGN KEY (team_id)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE public.team
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character(10) COLLATE pg_catalog."default",
    course_name character(1) COLLATE pg_catalog."default",
    CONSTRAINT team_pkey PRIMARY KEY (id)
)

CREATE TABLE public.team_educator
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    team_id integer,
    educator_id integer,
    CONSTRAINT group_educator_pkey PRIMARY KEY (id),
    CONSTRAINT educator_pk FOREIGN KEY (educator_id)
        REFERENCES public.educator (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT team_fk FOREIGN KEY (team_id)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)


