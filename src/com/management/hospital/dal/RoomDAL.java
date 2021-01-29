package com.management.hospital.dal;

import com.management.hospital.domain.Room;

public class RoomDAL extends BaseDAL {
	
	// Queries of Room Table
	
	public void insertRoom(Room room) {
		String queryInsertRoom = Queries.INSERTROOM.getQuery();
		String replaceQueryWithParams = String.format(queryInsertRoom, room.getRoom_no(), room.getRoom_type(),
				room.getStatus(), room.getPatient_id());

		commitStatement(replaceQueryWithParams);

	}

	public void updateRoom(int oldPatient_id, Room room) {
		commitStatement(String.format(Queries.UPDATEROOM.getQuery(), room.getRoom_no(), room.getRoom_type(),
				room.getStatus(), room.getPatient_id(), oldPatient_id));
	}
	
	public void selectRoom(int room_no) {
		getResultSet(String.format(Queries.SELECTROOM.getQuery(), room_no));

}
}

