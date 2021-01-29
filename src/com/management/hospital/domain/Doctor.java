package com.management.hospital.domain;

public class Doctor {
	private int doctor_id;
	private String name;
	private String surname;
	private int age;
	private String gender;
	private String address;

	// DEFAULT CONSTRUCTOR
	public Doctor() {

	}

	// CONSTRUCTOR WITHOUT THE ID FIELD
	public Doctor(String name, String surname, int age, String gender, String address) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	// CONSTRUCTOR WITH ALL FIELDS
	public Doctor(int doctor_id, String name, String surname, int age, String gender, String address) {
		this.doctor_id = doctor_id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	// GETTERS AND SETTERS
	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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

}
