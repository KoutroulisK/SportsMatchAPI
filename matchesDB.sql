--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23 (Ubuntu 10.23-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.23 (Ubuntu 10.23-0ubuntu0.18.04.1)

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
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: match; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.match (
    id integer NOT NULL,
    description character varying(255),
    match_date date,
    match_time time without time zone,
    team_a character varying(64),
    team_b character varying(64),
    sport smallint
);


ALTER TABLE public.match OWNER TO postgres;

--
-- Name: match_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.match_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.match_id_seq OWNER TO postgres;

--
-- Name: match_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.match_id_seq OWNED BY public.match.id;


--
-- Name: match_odds; Type: TABLE; Schema: public; Owner: matches_user
--

CREATE TABLE public.match_odds (
    id integer NOT NULL,
    odd real NOT NULL,
    specifier character(1) NOT NULL,
    match_id integer
);


ALTER TABLE public.match_odds OWNER TO matches_user;

--
-- Name: match_odds_id_seq; Type: SEQUENCE; Schema: public; Owner: matches_user
--

CREATE SEQUENCE public.match_odds_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.match_odds_id_seq OWNER TO matches_user;

--
-- Name: match_odds_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: matches_user
--

ALTER SEQUENCE public.match_odds_id_seq OWNED BY public.match_odds.id;


--
-- Name: matchodds; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matchodds (
    id integer NOT NULL,
    match_id integer,
    specifier character varying(1),
    odd numeric
);


ALTER TABLE public.matchodds OWNER TO postgres;

--
-- Name: matchodds_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matchodds_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.matchodds_id_seq OWNER TO postgres;

--
-- Name: matchodds_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matchodds_id_seq OWNED BY public.matchodds.id;


--
-- Name: match id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match ALTER COLUMN id SET DEFAULT nextval('public.match_id_seq'::regclass);


--
-- Name: match_odds id; Type: DEFAULT; Schema: public; Owner: matches_user
--

ALTER TABLE ONLY public.match_odds ALTER COLUMN id SET DEFAULT nextval('public.match_odds_id_seq'::regclass);


--
-- Name: matchodds id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matchodds ALTER COLUMN id SET DEFAULT nextval('public.matchodds_id_seq'::regclass);


--
-- Name: match_odds match_odds_pkey; Type: CONSTRAINT; Schema: public; Owner: matches_user
--

ALTER TABLE ONLY public.match_odds
    ADD CONSTRAINT match_odds_pkey PRIMARY KEY (id);


--
-- Name: match match_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT match_pkey PRIMARY KEY (id);


--
-- Name: matchodds matchodds_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matchodds
    ADD CONSTRAINT matchodds_pkey PRIMARY KEY (id);


--
-- Name: match_odds fk95q20mrlhen1b5nvm70rjdcgd; Type: FK CONSTRAINT; Schema: public; Owner: matches_user
--

ALTER TABLE ONLY public.match_odds
    ADD CONSTRAINT fk95q20mrlhen1b5nvm70rjdcgd FOREIGN KEY (match_id) REFERENCES public.match(id);


--
-- Name: matchodds fk_match_matchodds; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matchodds
    ADD CONSTRAINT fk_match_matchodds FOREIGN KEY (match_id) REFERENCES public.match(id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT USAGE ON SCHEMA public TO matches_user;


--
-- Name: TABLE match; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.match TO matches_user;


--
-- Name: SEQUENCE match_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.match_id_seq TO matches_user;


--
-- Name: TABLE matchodds; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.matchodds TO matches_user;


--
-- Name: SEQUENCE matchodds_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.matchodds_id_seq TO matches_user;


--
-- PostgreSQL database dump complete
--

