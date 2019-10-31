

create table public.role
(
	id bigserial not null
		constraint role_pkey
			primary key,
	name varchar(100)
)
;

alter table public.role owner to cinimex
;

create table public.users
(
	id bigserial not null
		constraint users_pkey
			primary key,
	name varchar(200),
	surname varchar(200),
	lastname varchar(200),
	login varchar(300),
	password varchar(600),
	role_id integer
		constraint users_role_id_fk
			references role,
	date_registration timestamp,
	dob timestamp
)
;

alter table public.users owner to cinimex
;

create unique index users_login_uindex
	on public.users (login)
;

create table public.balance
(
	id bigserial not null
		constraint balance_pkey
			primary key,
	money integer,
	number_of_balance varchar(20),
	is_lock boolean NOT NULL,
	user_id integer
		constraint balance_users_id_fk
			references users
)
;

alter table public.balance owner to cinimex
;

create unique index balance_number_of_balance_uindex
	on public.balance (number_of_balance)
;

create table public.transfer
(
	id bigserial not null
		constraint transfer_pk
			primary key,
	from_balance_id integer
		constraint transfer_balance_id_fk
			references balance,
	to_balance_id integer
		constraint transfer_balance_id_fk_2
			references balance
)
;

alter table public.transfer owner to cinimex
;

create table operation
(
	id bigserial not null
		constraint operation_pkey
			primary key,
	name varchar(200)
)
;

alter table operation owner to cinimex
;


create table journal
(
	id bigserial not null
		constraint journal_pkey
			primary key,
	operation_id integer
		constraint journal_operation_id_fk
			references operation,
	money integer,
	time timestamp,
	transfer_id integer
		constraint journal_transfer_id_fk
			references transfer,
	transfer_text varchar(300)
)
;

alter table journal owner to cinimex
;


alter table public.journal owner to cinimex
;


alter sequence public.role_id_seq owner to cinimex
;

alter sequence public.users_id_seq owner to cinimex
;

alter sequence public.balance_id_seq owner to cinimex
;


alter sequence public.journal_id_seq owner to cinimex
;

alter sequence public.transfer_id_seq owner to cinimex
;

alter sequence public.journal_id_seq owner to cinimex;