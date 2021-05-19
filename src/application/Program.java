package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaymentService;
import model.services.PaypalTaxService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date: ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		Contract contract = new Contract(number, date, contractValue);
		
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		
		PaymentService paymentService = new PaymentService(new PaypalTaxService());
		
		paymentService.processContract(contract, installments);
		
		System.out.println("Installments: ");
		for (Installment x : contract.getInstallment()) {
			System.out.println(x);
		}
		
		sc.close();

	}

}
