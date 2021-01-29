package com.management.hospital.dal;

public enum Queries {

	// Patient Table Query
	SELECTPATIENT("SELECT age, disease FROM patient WHERE patient_id='%d'"),
	 INSERTPATIENT("INSERT INTO patient (name, surname, age, gender, address, disease, doctor_id) "
	 		+ "VALUES  ( '%s', '%s', '%d', '%s', '%s', '%s', '%d')"),
	 UPDATEPATIENT("UPDATE patient SET  name = '%s', surname= '%s', age= '%d', gender='%s',"
	 +" address = '%s', disease = '%s', doctor_id = '%d' WHERE patient_id = '%d'"),
	 DELETEPATIENT("DELETE FROM patient WHERE patient_id = '%d'"),

	// Doctor Table Query
	 SELECTDOCTOR("SELECT age, address FROM doctor WHERE doctor_id='%d'"),
	 INSERTDOCTOR("INSERT INTO doctor  (name, surname, age, gender, address)"
	 		+ " VALUES ( '%s', '%s', '%d', '%s', '%s')"),
	UPDATEDOCTOR("UPDATE doctor SET  name = '%s', surname= '%s', age= '%d', gender='%s',"
			 +" address = '%s' WHERE doctor_id = '%d'"),
	DELETEDOCTOR("DELETE FROM doctor WHERE doctor_id = '%d'"),
	
	//Room Table Query
	SELECTROOM("SELECT room_type, status FROM room WHERE room_no='%d'"),
	INSERTROOM("INSERT INTO room (room_no, room_type, status, patient_id"
			+ " VALUES ('%d', '%s', '%s', '%d')"),
	UPDATEROOM("UPDATE room SET status = '%s' WHERE patient_id = '%d'"),
	
	//Laboratory Table Query
	SELECTLABORATORY("SELECT day FROM laboratory WHERE lab_no='%d' "),
	INSERTLABORATORY("INSERT INTO laboratory(lab_no, patient_id, doctor_id, day"
			+ " VALUES ('%d', '%d', '%d', '%s')"),
	UPDATELABORATORY("UPDATE laboratory SET status = 'active' WHERE doctor_id = '%d'"),
	
	//Bill Table Query
	SELECTBILL("SELECT doctor_charge, room_charge, no_of_days, lab_charge FROM bill WHERE bill_no='%d' "),
	INSERTBILL("INSERT INTO bill(bill_no, patient_id, doctor_charge, room_charge, no_of_days, lab_charge"
			+ " VALUES ('%d', '%d', '%f', '%f', '%d', '%f')"),
	UPDATEBILL("UPDATE bill SET bill_no= '%d', patient_id= '%d', doctor_charge= '%f', room_charge='%f', no_of_days= '%d', "
			+"lab_charge='%f' WHERE patient_id= '%d'");
	

	private String query;

	private Queries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

}

