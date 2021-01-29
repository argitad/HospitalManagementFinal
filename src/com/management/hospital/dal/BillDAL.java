package com.management.hospital.dal;

import com.management.hospital.domain.Bill;


public class BillDAL extends BaseDAL {
	
	public void insertBill(Bill bill) {
		String queryInsertBill = Queries.INSERTBILL.getQuery();
		String replaceQueryWithParams = String.format(queryInsertBill, bill.getBill_no(), bill.getPatient_id(),
				bill.getDoctor_charge(), bill.getRoom_charge(), bill.getNo_of_days(), bill.getLab_charge());

		commitStatement(replaceQueryWithParams);

	}
	

	public void updateBill(int oldPatient_id, Bill bill) {
		commitStatement(String.format(Queries.UPDATEBILL.getQuery(), bill.getBill_no(), bill.getPatient_id(),
				bill.getDoctor_charge(), bill.getRoom_charge(), bill.getNo_of_days(), bill.getLab_charge(), oldPatient_id));
	}
	
	public void selectBill(int bill_no) {
		getResultSet(String.format(Queries.SELECTBILL.getQuery(), bill_no));

}
}

