package com.cts.EBanking;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();

		// CODE SKELETON - VALIDATION ENDS

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		SmartBankAccount sba = ac.getBean("smartBankAccount", SmartBankAccount.class);
		NumberFormat ft = new DecimalFormat("#0.00");
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Welcome Mr/Ms: " + sba.getName());
		System.out.println("Your customer id is: " + sba.getCustomerId());
		System.out.println("Please select account type");
		System.out.println("1 " + sba.getAccounts().get(0));
		System.out.println("2 " + sba.getAccounts().get(1));
		System.out.println("3 " + sba.getAccounts().get(2));
		switch (scanner.nextInt()) {
		case 1:
			System.out.println("Select transaction type \n 1.Deposit \n 2.Withdraw");
			int choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter amount to be deposited");
				System.out.println("Your balance amount is " + ft.format(sba.doDeposit(scanner.nextDouble())));

			} else if (choice == 2) {
				System.out.println("Enter amount to be withdrawn");
				System.out.println("Your balance amount is " + ft.format(sba.doWithdraw(scanner.nextDouble())));

			} else {
				System.out.println("Wrong choice");
			}
			break;
		case 2:
			System.out.println("Enter monthly installment");
			double monthly = scanner.nextDouble();
			System.out.println("Enter monthly installment");
			int tm = scanner.nextInt();
			System.out.println("Your balance after " + tm + " months will be " + ft.format(sba.calculateRecurringAccount(monthly, tm)));
			break;
		case 3:
			System.out.println("Enter FD amount");
			double fd = scanner.nextDouble();
			System.out.println("Enter tenure in months");
			int tem = scanner.nextInt();
			System.out.println("Your balance after " + tem + " months will be " + ft.format(sba.calculateFixedAccount(fd, tem)));
			break;

		default:
			System.out.println("Wrong Choice");

		}

	}
}
