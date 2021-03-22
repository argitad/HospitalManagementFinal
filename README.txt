Hi, :)

This is my first JDBC Application which I developed during the
"Java Programming" training for two months now at Dominusoft Trainings.


Project description:

The project is a hospital management system and it's divided respectively 
into 5 packages:
 
1) com.management.hospital.domain where all the classes were created including 
their constructors, getters and setters.
2) com.management.hospital.dal which represents the Data Access Layer or
the connectivity whith the database.
3) com.management.hospital.ui which includes the classes of the User Interface.
4) sql which includes the sql scripts of creating the tables in the database.
5) tests where I tested the code.


BEFORE RUNNING THE PROJECT READ THIS NOTICE:

Go to hospital_management_system > sql > create-database.sql 
                                       > create-doctor-table.sql
                                       > create-patient-table.sql
                                       > create-room-table.sql
                                       > create-laboratory-table.sql
                                       > create-bill-table.sql
These scripts should be used to create the database and the tables, just like
in the ER Diagram image at the same package.

Go to hospital_management_system < com.management.hospital.dal < BaseDAL.java
                                 < com.management.hospital.ui < Gui Connection.java
Change the credentials of my database (url, username, password) with yours.

At hospital_management_system > lib > mysql-connector-java-8.0.22.jar ,
this folder contains the JAR File for connecting the project to MySql Database.
For additional downloads and the source of MySQL Connector/J visit:
https://dev.mysql.com/downloads/


Run the project:

Go to hospital_management_system > com.management.hospital.ui >AdminFrame.java
and Run it as a Java Application.
Make sure you type "admin" in both textfields, username and password.

Right after you login as an Admin, you will go to the WelcomeFrame, where you 
can choose whether to continue to Doctor's Profile, or Patient's Profile.

Doctor's Profile will take you next to LaboratoryFrame, where, based on Doctor ID,
you will assign one Laboratory Number.

Patient's Profile will take you to RoomFrame, where, based on Patient ID, you will
assign one Room Number.

RoomFrame then, will take you to BillFrame, where you as an admin will calculate
the total charge of the patient.

Meanwhile as you Add, Edit or Delete rows in all the frames, changes will be
reflected at the tables of the database as well.

In addition, if you notice that when creating new rows at doctor and patient tables,
the doctor_id and patient_id may seem like they are not auto-incremented. That's
because when I tested the code, I have deleted the last row, meanwhile it keeps
incrementing, including the id of the deleted row.


Hope you like my mini application! :D






