

create sequence company_id_seq;
create sequence payment_company_id_seq;
create sequence payment_user_id_seq;

create table company
(
	id bigint default company_id_seq.nextval not null
		constraint company_pk
			primary key,
	name varchar(300),
	balance_id integer
		constraint company_balance_id_fk
			references balance,
	number_of_card integer
)
;


create table payment_company
(
	id bigint default payment_company_id_seq.nextval not null
		constraint payment_company_pkey
			primary key,
	name varchar(300),
	amount integer,
	company_id integer
		constraint payment_company_company_id_fk
			references company
)
;

create unique index payment_company_name_uindex
	on payment_company (name)
;

create table payment_user
(
	id bigint default payment_user_id_seq.nextval not null
		constraint payment_user_pkey
			primary key,
	payment_company_id integer
		constraint payment_user_payment_company_id_fk
			references payment_company,
	user_id integer
		constraint payment_user_users_id_fk
			references users,
	money integer,
	paid boolean
)
;
