package com.management.hospital.dal;

import com.management.hospital.domain.Doctor;
import com.management.hospital.domain.Patient;

// Queries of Doctor Table
public class DoctorDAL extends BaseDAL {

	public void insertDoctor(Doctor doctor) {
		String queryInsertDoctor = Queries.INSERTDOCTOR.getQuery();
		String replaceQueryWithParams = String.format(queryInsertDoctor, doctor.getName(),
				doctor.getSurname(), doctor.getAge(), doctor.getGender(), doctor.getAddress());

		commitStatement(replaceQueryWithParams);

	}
	

	public void updateDoctor(int oldDoctor_id, Doctor doctor) {
		commitStatement(String.format(Queries.UPDATEDOCTOR.getQuery(), doctor.getDoctor_id(), doctor.getName(),
				doctor.getSurname(), doctor.getAge(), doctor.getGender(), doctor.getAddress(), oldDoctor_id));
	}

	public void deleteDoctor(int doctor_id) {
		commitStatement(String.format(Queries.DELETEDOCTOR.getQuery(), doctor_id));
		
	}
	
	public void selectDoctor(int doctor_id) {
		getResultSet(String.format(Queries.SELECTDOCTOR.getQuery(), doctor_id));

}
}

