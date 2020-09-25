-- public.simcard definition

-- Drop table

-- DROP TABLE public.simcard;

CREATE TABLE simcard (
	id serial NOT NULL,
	simcard varchar NOT NULL,
	CONSTRAINT simcard_un UNIQUE (simcard)
);


-- public.vocher definition

-- Drop table

-- DROP TABLE public.vocher;

CREATE TABLE vocher (
	simcard varchar NOT NULL,
	create_date timestamp NOT NULL,
	vocher varchar NULL,
	status varchar NULL,
	action_date timestamp NULL,
	CONSTRAINT vocher_pk PRIMARY KEY (simcard, create_date),
	CONSTRAINT vocher_fk FOREIGN KEY (simcard) REFERENCES simcard(simcard)
);


-- public.history definition

-- Drop table

-- DROP TABLE public.history;

CREATE TABLE history (
	id serial NOT NULL,
	interaction_date timestamp NOT NULL,
	status varchar NULL,
	simcard varchar NOT NULL,
	CONSTRAINT history_pk PRIMARY KEY (interaction_date, simcard),
	CONSTRAINT history_fk FOREIGN KEY (simcard) REFERENCES simcard(simcard)
);