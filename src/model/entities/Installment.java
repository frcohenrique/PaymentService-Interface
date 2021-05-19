package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

//prestação

public class Installment {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Date dueDate;
	public Double amount;
	
	public Installment() {
		
	}
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	

	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
 	}
	
	
}
