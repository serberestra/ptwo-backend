insert into sh_user(id, username, password, user_type, phone_number) values(1010, 'test@test.com', 'test', 'user', '3053051111');
insert into sh_user(id, username, password, user_type, phone_number) values(1020, 'admin@admin.com', 'admin', 'company', '3053052222');
insert into sh_user(id, username, password, user_type, phone_number) values(1030, 'abc@abc.com', 'admin', 'company', '3053053333');
insert into sh_user(id, username, password, user_type, phone_number) values(1040, 'xyz@xyz.com', 'admin', 'company', '3053054444');
insert into sh_user(id, username, password, user_type, phone_number) values(1050, '123@123.com', 'admin', 'company', '3053054444');

insert into sh_company(id, name, phone_number, address) values(5001, 'ABC Pressure Gutter', '(808)123', '120 Ruby St.');
insert into sh_company(id, name, phone_number, address) values(5002, 'XYZ Electronics', '(565)345', '150 Silver St.');
insert into sh_company(id, name, phone_number, address) values(5003, '123 Barber Shop', '(978)535', '123 Springfield');

insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1001,'Rich', 'Black', 5001, 'Gutter Clean');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1002,'Michael', 'Jackson', 5002, 'Songwriter');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1003,'Joe', 'Black', 5002, 'Screen Fix');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1004,'Homer', 'Simpson', 5003, 'Haircut');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1005,'Tom', 'Jerry', 5003, 'Beard cuts');	
