
create sequence IF NOT EXISTS users_id_seq;
create sequence IF NOT EXISTS transfer_id_seq;
create sequence IF NOT EXISTS journal_id_seq;
create sequence IF NOT EXISTS balance_id_seq;
create table IF NOT EXISTS role
(
	id integer not null
		constraint role_pkey
			primary key,
	name varchar(100)
)
;


create table IF NOT EXISTS users
(
	id bigint default users_id_seq.nextval not null
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
	is_deleted boolean NOT NULL,
	dob timestamp
)
;

create unique index IF NOT EXISTS users_login_uindex
	on users (login)
;

create table IF NOT EXISTS balance
(
	id bigint default balance_id_seq.nextval not null
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


create unique index IF NOT EXISTS balance_number_of_balance_uindex
	on balance (number_of_balance)
;

create table IF NOT EXISTS transfer
(
	id bigint default transfer_id_seq.nextval not null
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


create table IF NOT EXISTS operation
(
	id integer not null
		constraint operation_pkey
			primary key,
	name varchar(200)
)
;


create table IF NOT EXISTS journal
(
	id bigint default journal_id_seq.nextval not null
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