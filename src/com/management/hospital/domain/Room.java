package com.management.hospital.domain;

public class Room {
	private int room_no;
	private String room_type;
	private String status;
	private int patient_id;

	public Room(int room_no, String room_type, String status, int patient_id) {

		this.room_no = room_no;
		this.room_type = room_type;
		this.status = status;
		this.patient_id = patient_id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

}


