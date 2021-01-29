package com.management.hospital.domain;

import java.time.LocalDate;
import java.util.Date;
  

public class Laboratory {

	private int lab_no;
	private int patient_id;
	private int doctor_id;
	private LocalDate day;

	public Laboratory(int lab_no, int patient_id, int doctor_id, LocalDate localDate) {

		this.lab_no = lab_no;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.day = localDate;
	}

	

	public int getLab_no() {
		return lab_no;
	}

	public void setLab_no(int lab_no) {
		this.lab_no = lab_no;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public LocalDate getDay() { 
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

}
