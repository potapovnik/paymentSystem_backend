create table company
(
	id bigserial not null
		constraint company_pk
			primary key,
	name varchar(300),
	balance_id integer
		constraint company_balance_id_fk
			references balance,
	number_of_card integer
)
;

alter table company owner to cinimex
;


create table payment_company
(
	id bigserial not null
		constraint payment_company_pkey
			primary key,
	name varchar(300),
	amount integer,
	company_id integer
		constraint payment_company_company_id_fk
			references company
)
;

alter table payment_company owner to cinimex
;

create unique index payment_company_name_uindex
	on payment_company (name)
;

create table payment_user
(
	id bigserial not null
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

alter table payment_user owner to cinimex
;

