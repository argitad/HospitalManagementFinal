package com.management.hospital.domain;

public class Bill {

	private int bill_no;
	private int patient_id;
	private double doctor_charge;
	private double room_charge;
	private int no_of_days;
	private double lab_charge;

	public Bill(int bill_no, int patient_id, double doctor_charge, double room_charge, int no_of_days,
			double lab_charge) {

		this.bill_no = bill_no;
		this.patient_id = patient_id;
		this.doctor_charge = doctor_charge;
		this.room_charge = room_charge;
		this.no_of_days = no_of_days;
		this.lab_charge = lab_charge;
		
		
		
	}

	public int getBill_no() {
		return bill_no;
	}

	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public double getDoctor_charge() {
		return doctor_charge;
	}

	public void setDoctor_charge(double doctor_charge) {
		this.doctor_charge = doctor_charge;
	}

	public double getRoom_charge() {
		return room_charge;
	}

	public void setRoom_charge(double room_charge) {
		this.room_charge = room_charge;
	}

	public int getNo_of_days() {
		return no_of_days;
	}

	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}

	public double getLab_charge() {
		return lab_charge;
	}

	public void setLab_charge(double lab_charge) {
		this.lab_charge = lab_charge;
	}
	

	public double totalBillCharge() {
		double total_charge = (this.doctor_charge+this.room_charge+this.lab_charge)*this.no_of_days;
		return total_charge;
	}

}

