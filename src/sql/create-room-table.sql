create table laboratory (
lab_no int,
patient_id int,
doctor_id int,
day date,
primary KEY(lab_no),
FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);



