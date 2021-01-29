create table room (
room_no int,
room_type varchar(100),
status varchar(100),
patient_id int,
primary key (room_no),
FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);



