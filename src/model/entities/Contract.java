package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	public Date date;
	public Integer number;
	public Double totalValue;
	
	public List<Installment> installments = new ArrayList<>();
	
	public Contract(){
		
	}
	public Contract(Integer number, Date date, Double totalValue) {
		
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installment> getInstallment(){
		return installments;
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
}
