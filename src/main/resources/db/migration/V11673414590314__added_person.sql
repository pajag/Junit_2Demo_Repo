CREATE TABLE IF NOT EXISTS public.person(

  person_id numeric,
  person_name text,
  person_city text,
  CONSTRAINT users_pkey PRIMARY KEY (person_id),
);