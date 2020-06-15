insert into sh_user(id, username, password, user_type, phone_number) values(1010, 'test@test.com', 'test', 'user', '3053051111');
insert into sh_user(id, username, password, user_type, phone_number) values(1020, 'admin@admin.com', 'admin', 'company', '3053052222');
insert into sh_user(id, username, password, user_type, phone_number) values(1030, 'abc@abc.com', 'admin', 'company', '3053053333');
insert into sh_user(id, username, password, user_type, phone_number) values(1040, 'xyz@xyz.com', 'admin', 'company', '3053054444');
insert into sh_user(id, username, password, user_type, phone_number) values(1050, '123@123.com', 'admin', 'company', '3053054444');
insert into sh_user(id, username, password, user_type, phone_number) values(1060, 'bill@microsoft.com', 'bill', 'user', '1-1111');

insert into sh_company(id, name, phone_number, address, user_id) values(5002, 'XYZ Electronics', '(565)345', '150 Silver St.', 1040);
insert into sh_company(id, name, phone_number, address, user_id) values(5003, '123 Barber Shop', '(978)535', '123 Springfield', 1050);
insert into sh_company(id, name, phone_number, address, user_id) values(5004, 'Buy More', '(777)235', '300 Bronze St', 1020);

insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1001,'Rich', 'Taylor', 5004, 'Gutter Clean', 1);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1002,'Michael', 'Cruz', 5002, 'Appliance Installation', 1);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1003,'Joe', 'White', 5004, 'Electrical Rewiring', 1);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1004,'Homer', 'Simpson', 5003, 'Aircon Maintenance', 1);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1005,'Luke', 'Johnson', 5004, 'Appliance Installation', 0);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1006,'Larry', 'Nance', 5002, 'TV Calibration', 1);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1007,'John', 'Bunyan', 5004, 'Appliance Installation', 0);	
insert into sh_worker(id, first_name, last_name, company_id, service_name, available) values(1008,'Terry', 'King', 5004, 'TV Calibration', 1);	

insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(313, 1001, to_date('07/01/2020', 'MM/DD/YYYY'), 1, 1010);	
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(314, 1002, to_date('07/05/2020', 'MM/DD/YYYY'), 1, 1060);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(315, 1002, to_date('07/12/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(316, 1003, to_date('07/13/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(317, 1004, to_date('07/13/2020', 'MM/DD/YYYY'), 1, 1060);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(318, 1005, to_date('07/14/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(319, 1006, to_date('07/18/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(320, 1007, to_date('07/19/2020', 'MM/DD/YYYY'), 0, null);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(321, 1006, to_date('07/20/2020', 'MM/DD/YYYY'), 1, 1010);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(322, 1007, to_date('07/21/2020', 'MM/DD/YYYY'), 1, 1010);
insert into sh_reservation(id, worker_id, reservation_date, status, booked_by) values(323, 1008, to_date('07/23/2020', 'MM/DD/YYYY'), 1, 1010);
