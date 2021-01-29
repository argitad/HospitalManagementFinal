package tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.management.hospital.dal.BillDAL;
import com.management.hospital.dal.DoctorDAL;
import com.management.hospital.dal.LaboratoryDAL;
import com.management.hospital.dal.PatientDAL;
import com.management.hospital.dal.RoomDAL;
import com.management.hospital.domain.Bill;
import com.management.hospital.domain.Doctor;
import com.management.hospital.domain.Laboratory;
import com.management.hospital.domain.Patient;
import com.management.hospital.domain.Room;

public class TestDAL {

	public static void main(String[] args) {
	/*	// CREATE MOCK DOCTOR OBJECT
      DoctorDAL doctorDAL = new DoctorDAL();
		
        //Doctor doctor = new Doctor("jane", "doe", 35, "female", "tirana");
		//Doctor doctor1 = new Doctor("john", "doe", 35, "male", "tirana");
		Doctor doctor2 = new Doctor("main", "naim", 40, "male", "shkoder");
		//doctorDAL.insertDoctor(doctor);
		//doctorDAL.insertDoctor(doctor1);
		//doctorDAL.insertDoctor(doctor2);
		//doctorDAL.updateDoctor(1, doctor2); 
		doctorDAL.deleteDoctor(14);
		*/
		 // CREATE MOCK PATIENT OBJECT
		   PatientDAL patientDAL = new PatientDAL();

		//Patient patient = new Patient("jane", " newmann", 13, "female", "usa", "obesity", 6);
		//Patient patient1 = new Patient("dsa", " dsa", 21, "male", "durres", "flu", 2);
		//Patient patient2 = new Patient("kay", " ok", 60, "female", "kukes", "diabetes", 9);
		Patient patient3 = new Patient("alfred", " schmidt", 45, "male", "frankfurt", "flu", 2);
		          // Patient patient4 = new Patient("n", "o", 55, "male", "berat", "heart disease", 5);
		//patientDAL.insertPatient(patient);
		//patientDAL.insertPatient(patient1);
		//patientDAL.insertPatient(patient2); 
		patientDAL.updatePatient(5, patient3);
		   
		           // patientDAL.updatePatient(14, patient4);
		//patientDAL.deletePatient(0);
		    //patientDAL.selectPatient(0);
		          // System.out.println("successfull");
	/*	//CREATE MOCK ROOM OBJECT
		RoomDAL roomDAL= new RoomDAL();
		
		Room room= new Room(1, "standart", "active", 6);
		roomDAL.insertRoom(room);

		
		
		//CREATE MOCK LABORATORY OBJECT
		LaboratoryDAL laboratoryDAL= new LaboratoryDAL();
		  
		Laboratory laboratory= new Laboratory(3, 3, 4, java.time.LocalDate.now());
		//laboratoryDAL.insertLaboratory(laboratory);
*/
		
		 //CREATE MOCK BILL OBJECT
		//BillDAL billDAL= new BillDAL();
		
		//Bill bill = new Bill(4, 3, 20.1, 13.5, 3, 14.0);
		//Bill bill1 = new Bill(3, 4, 20.1, 13.5, 3, 14.0);
		//bill.totalBillCharge();
		
		//billDAL.insertBill(bill);
		//billDAL.updateBill(3, bill1);
		//billDAL.selectBill(4);
		
		//System.out.println(bill.totalBillCharge()); 
		System.out.println("successful"); 


	}

}

