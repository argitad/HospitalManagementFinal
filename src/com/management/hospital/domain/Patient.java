package com.management.hospital.domain;

public class Patient {
	private int patient_id;
	private String name;
	private String surname;
	private int age;
	private String gender;
	private String address;
	private String disease;
	private int doctor_id;

	// DEFAULT CONSTRUCTOR
	public Patient() {

	}

	// CONSTRUCTOR WITHOUT THE ID FIELD
	public Patient(String name, String surname, int age, String gender, String address, String disease, int doctor_id) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.disease = disease;
		this.doctor_id = doctor_id;
	}

	// CONSTRUCTOR WITH ALL THE FIELDS
	public Patient(int patient_id, String name, String surname, int age, String gender, String address, String disease,
			int doctor_id) {

		this.patient_id = patient_id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.disease = disease;
		this.doctor_id = doctor_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

}
