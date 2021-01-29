package com.management.hospital.dal;

import com.management.hospital.domain.Laboratory;

public class LaboratoryDAL extends BaseDAL {

	public void insertLaboratory(Laboratory laboratory) {
		String queryInsertLaboratory = Queries.INSERTLABORATORY.getQuery();
		String replaceQueryWithParams = String.format(queryInsertLaboratory, laboratory.getLab_no(),
				laboratory.getPatient_id(), laboratory.getDoctor_id(), laboratory.getDay());

		commitStatement(replaceQueryWithParams);

	}

	public void updateLaboratory(int oldDoctor_id, Laboratory laboratory) {
		commitStatement(String.format(Queries.UPDATELABORATORY.getQuery(), laboratory.getLab_no(),
				laboratory.getPatient_id(), laboratory.getDoctor_id(), laboratory.getDay(), oldDoctor_id));
	}
	
	public void selectLaboratory(int lab_no) {
		getResultSet(String.format(Queries.SELECTLABORATORY.getQuery(), lab_no));

}
	
}

