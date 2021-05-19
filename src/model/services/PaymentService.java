package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class PaymentService {

	private TaxService taxService;
	
	public PaymentService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i<=months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updatedQuota = basicQuota + taxService.interest(basicQuota, i);
			double fullQuota = updatedQuota + taxService.paymentFee(updatedQuota);
			contract.addInstallment(new Installment(date, fullQuota));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
}
