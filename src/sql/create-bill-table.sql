create table Bill (
bill_no int,
patient_id int,
doctor_charge double,
room_charge double,
no_of_days int,
lab_charge double,
PRIMARY KEY (bill_no),
FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);


