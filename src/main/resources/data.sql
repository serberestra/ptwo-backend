insert into sh_user(id, username, password, user_type, phone_number) values(1010, 'test@test.com', 'test', 'user', '3053051111');
insert into sh_user(id, username, password, user_type, phone_number) values(1020, 'admin@admin.com', 'admin', 'company', '3053052222');
insert into sh_user(id, username, password, user_type, phone_number) values(1030, 'abc@abc.com', 'admin', 'company', '3053053333');
insert into sh_user(id, username, password, user_type, phone_number) values(1040, 'xyz@xyz.com', 'admin', 'company', '3053054444');
insert into sh_user(id, username, password, user_type, phone_number) values(1050, '123@123.com', 'admin', 'company', '3053054444');

insert into sh_user(id, username, password, user_type, phone_number) values(1060, 'bill@microsoft.com', 'bill', 'user', '1-1111');
insert into sh_user(id, username, password, user_type, phone_number) values(1070, 'jeff@amazon.com', 'jeff', 'user', '2-2222');
insert into sh_user(id, username, password, user_type, phone_number) values(1080, 'tim@apple.com', 'tim', 'user', '3-3333');
insert into sh_user(id, username, password, user_type, phone_number) values(1090, 'nadel@microsoft.com', 'nadel', 'user', '4-4444');
insert into sh_user(id, username, password, user_type, phone_number) values(1100, 'Buy More', 'buymore', 'company', '5-5555');

insert into sh_company(id, name, phone_number, address, user_id) values(5001, 'ABC Pressure Gutter', '(808)123', '120 Ruby St.', 1030);
insert into sh_company(id, name, phone_number, address, user_id) values(5002, 'XYZ Electronics', '(565)345', '150 Silver St.', 1040);
insert into sh_company(id, name, phone_number, address, user_id) values(5003, '123 Barber Shop', '(978)535', '123 Springfield', 1050);
insert into sh_company(id, name, phone_number, address, user_id) values(5004, 'Buy More', '(777)235', '300 Bronze St', 1020);

insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1001,'Rich', 'Black', 5001, 'Gutter Clean');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1002,'Michael', 'Jackson', 5002, 'Appliance Installation');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1003,'Joe', 'Black', 5002, 'Electrical Rewiring');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1004,'Homer', 'Simpson', 5003, 'Aircon Maintenance');	
insert into sh_worker(id, first_name, last_name, company_id, service_name) values(1005,'Tom', 'Jerry', 5004, 'Appliance Installation');	

insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(313, 1001, to_date('07/01/2020', 'MM/DD/YYYY'), 1, 1060);	
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(314, 1002, to_date('07/05/2020', 'MM/DD/YYYY'), 1, 1070);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(315, 1002, to_date('07/12/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(316, 1003, to_date('07/13/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(317, 1004, to_date('07/13/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(318, 1005, to_date('07/14/2020', 'MM/DD/YYYY'), 0, null);
	
