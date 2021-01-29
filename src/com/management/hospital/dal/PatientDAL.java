package com.management.hospital.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.management.hospital.domain.Patient;

public class PatientDAL extends BaseDAL {
	
	private ArrayList<Patient> patientList;

	// Queries of Patient Table

	public void insertPatient(Patient patient) {
		String queryInsertPatient = Queries.INSERTPATIENT.getQuery();
		String replaceQueryWithParams = String.format(queryInsertPatient, patient.getName(),
				patient.getSurname(), patient.getAge(), patient.getGender(), patient.getAddress(), patient.getDisease(),
				patient.getDoctor_id());

		commitStatement(replaceQueryWithParams);

	}
	
	
	public void updatePatient(int oldPatient_id, Patient patient) {
		commitStatement(String.format(Queries.UPDATEPATIENT.getQuery(), patient.getName(),
				patient.getSurname(), patient.getAge(), patient.getGender(), patient.getAddress(), patient.getDisease(),
				patient.getDoctor_id(), oldPatient_id));
	}

	public void deletePatient(int patient_id) {
		commitStatement(String.format(Queries.DELETEPATIENT.getQuery(), patient_id));
		
	}
	
	public void selectPatient(int patient_id) {
		getResultSet(String.format(Queries.SELECTPATIENT.getQuery(), patient_id));
	}

		

	}
	



