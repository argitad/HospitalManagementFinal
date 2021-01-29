create table patient (
	patient_id int NOT NULL AUTO_INCREMENT, 
	name varchar(100),
	surname varchar(100),
	age int,
	gender varchar(100),
	address varchar(100),
	disease varchar(100),
	doctor_id int,
	primary key (patient_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);




