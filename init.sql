--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

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
-- Name: cryptocurrency; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cryptocurrency (
    id bigint NOT NULL,
    symbol character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    status boolean NOT NULL,
    current_price double precision NOT NULL
);


ALTER TABLE public.cryptocurrency OWNER TO postgres;

--
-- Name: cryptocurrency_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cryptocurrency_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cryptocurrency_id_seq OWNER TO postgres;

--
-- Name: cryptocurrency_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cryptocurrency_id_seq OWNED BY public.cryptocurrency.id;


--
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    id bigint NOT NULL,
    crypto_id bigint NOT NULL,
    type character varying(255) NOT NULL,
    amount numeric(38,2) NOT NULL,
    price numeric(38,2) NOT NULL,
    date timestamp(6) without time zone NOT NULL,
    user_id character varying(255)
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- Name: transactions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transactions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transactions_id_seq OWNER TO postgres;

--
-- Name: transactions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transactions_id_seq OWNED BY public.transactions.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    keycloak_id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: cryptocurrency id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cryptocurrency ALTER COLUMN id SET DEFAULT nextval('public.cryptocurrency_id_seq'::regclass);


--
-- Name: transactions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions ALTER COLUMN id SET DEFAULT nextval('public.transactions_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: cryptocurrency; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cryptocurrency (id, symbol, name, status, current_price) FROM stdin;
3	BTC	Bitcoin	f	0
1	BTC	Bitcoin	t	213.88482
2	DOGE	Dogecoin	t	0.032
4	ETH	Ethereum	f	1581.0132244676317
5	ADA	Cardano	t	0.2456058121749874
6	Arq	arquicoin	t	1002
7	sdf	test	t	1234
8	123451	test2	t	512312
\.


--
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (id, crypto_id, type, amount, price, date, user_id) FROM stdin;
1	1	BUY	0.03	90.12	2023-09-24 11:52:47.174	1
2	1	BUY	0.03	90.12	2023-09-24 11:53:47.812	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
3	1	BUY	0.03	90.12	2023-09-24 16:29:36.414	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
4	2	BUY	12.00	0.06	2023-09-24 17:07:54.854	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
5	2	SELL	42.00	0.06	2023-09-24 22:19:30.429	\N
6	1	SELL	4222.00	90.12	2023-09-24 22:19:30.476	\N
7	2	SELL	422.00	0.06	2023-09-24 22:22:22.776	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
8	2	SELL	1222.00	0.06	2023-09-24 22:22:22.816	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
9	1	SELL	52222222.00	90.12	2023-09-24 22:22:22.82	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
10	1	SELL	22.00	213.88	2023-09-25 14:58:17.963	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
11	2	SELL	1000000.00	0.03	2023-09-25 14:59:05.239	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f
12	2	SELL	4222.00	0.03	2023-09-25 15:21:29.924	ee7fa86d-a138-4bf1-9e36-475d73d44154
13	5		12.00	0.25	2023-09-25 15:21:29.937	ee7fa86d-a138-4bf1-9e36-475d73d44154
14	6	SELL	44.00	1002.00	2023-09-25 15:33:16.961	ee7fa86d-a138-4bf1-9e36-475d73d44154
15	5	SELL	3.00	0.25	2023-09-25 15:35:49.88	ee7fa86d-a138-4bf1-9e36-475d73d44154
16	1	SELL	42.00	213.88	2023-09-25 15:38:13.543	ee7fa86d-a138-4bf1-9e36-475d73d44154
17	1	BUY	422.00	213.88	2023-09-25 15:39:49.297	ee7fa86d-a138-4bf1-9e36-475d73d44154
18	2	SELL	45112.00	0.03	2023-09-25 16:44:43.173	ee7fa86d-a138-4bf1-9e36-475d73d44154
19	2	SELL	42.00	0.03	2023-09-25 16:49:14.715	ee7fa86d-a138-4bf1-9e36-475d73d44154
20	5	BUY	1112223.00	0.25	2023-09-25 16:49:14.72	ee7fa86d-a138-4bf1-9e36-475d73d44154
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, keycloak_id, name, username) FROM stdin;
1	a066b5ef-8c67-4f22-908c-a8a0bbe67b7f	Juan Perez	test-angular
2	ee7fa86d-a138-4bf1-9e36-475d73d44154	Juan Perez	angular-admin
\.


--
-- Name: cryptocurrency_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cryptocurrency_id_seq', 8, true);


--
-- Name: transactions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transactions_id_seq', 20, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


--
-- Name: cryptocurrency cryptocurrency_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cryptocurrency
    ADD CONSTRAINT cryptocurrency_pkey PRIMARY KEY (id);


--
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: transactions transactions_crypto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_crypto_id_fkey FOREIGN KEY (crypto_id) REFERENCES public.cryptocurrency(id);


--
-- PostgreSQL database dump complete
--

