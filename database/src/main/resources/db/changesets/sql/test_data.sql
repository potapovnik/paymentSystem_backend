insert into role (id, name) VALUES (1,'administrator');
insert into role (id, name) VALUES (2,'user');

insert into operation (id, name) VALUES (1,'BALANCE_TO_BALANCE');
insert into operation (id, name) VALUES (2,'TRANSFER_FROM_CARD');
insert into operation (id, name) VALUES (3,'TRANSFER_TO_CARD');
insert into operation (id, name) VALUES (4,'PAYMENT_FROM_BALANCE_TO_BALANCE');
insert into operation (id, name) VALUES (5,'PAYMENT_FROM_CARD_TO_BALANCE');
insert into operation (id, name) VALUES (6,'PAYMENT_FROM_CARD_AND_BALANCE_TO_BALANCE');

insert into users (name, surname, lastname, login, password, role_id, date_registration, dob)
VALUES ('Иван','Потёмкин','Фёдорович','admin','$2a$10$eTr6KOPUjaqXlzHs2wSwHem5uAPQuD53i0qExxEVNVa/sJzj5LEXu',1,null ,null );
insert into users (name, surname, lastname, login, password, role_id, date_registration, dob)
VALUES ('Алексей','Кузнецов','Петрович','user1','$2a$10$eTr6KOPUjaqXlzHs2wSwHem5uAPQuD53i0qExxEVNVa/sJzj5LEXu',2,null ,null );
insert into users (name, surname, lastname, login, password, role_id, date_registration, dob)
VALUES ('Григорий','Залесский','Сидорович','user2','$2a$10$eTr6KOPUjaqXlzHs2wSwHem5uAPQuD53i0qExxEVNVa/sJzj5LEXu',2,null ,null );
insert into users (name, surname, lastname, login, password, role_id, date_registration, dob)
VALUES ('Владелец','Сети','Теле2','tele2','$2a$10$eTr6KOPUjaqXlzHs2wSwHem5uAPQuD53i0qExxEVNVa/sJzj5LEXu',2,null ,null );
insert into users (name, surname, lastname, login, password, role_id, date_registration, dob)
VALUES ('Билайн','Соперник','Теле2','beeline','$2a$10$eTr6KOPUjaqXlzHs2wSwHem5uAPQuD53i0qExxEVNVa/sJzj5LEXu',2,null ,null );

insert into balance (money, number_of_balance,is_lock, user_id) VALUES (1000,'12345678901234567890',false ,1);
insert into balance (money, number_of_balance,is_lock, user_id) VALUES (100,'12345678901234567891',false ,2);
insert into balance (money, number_of_balance,is_lock, user_id) VALUES (100,'12345678901234567892',false ,3);
insert into balance (money, number_of_balance,is_lock, user_id) VALUES (100,'12345678901234567893',false ,4);
insert into balance (money, number_of_balance,is_lock, user_id) VALUES (100,'12345678901234567894',false ,5);

insert into company (name, balance_id, number_of_card) VALUES ('tele2',4,1234321);
insert into company (name, balance_id, number_of_card) VALUES ('beeline',5,132123);

insert into payment_company (name, amount, company_id) VALUES ('Пакет чёрный',350,1);
insert into payment_company (name, amount, company_id) VALUES ('Купить 100гб',100,1);
insert into payment_company (name, amount, company_id) VALUES ('Услуга чёрный список',20,1);
insert into payment_company (name, amount, company_id) VALUES ('Пакет фиолетово',200,2);
insert into payment_company (name, amount, company_id) VALUES ('Андекдоты/Новости',10,2);