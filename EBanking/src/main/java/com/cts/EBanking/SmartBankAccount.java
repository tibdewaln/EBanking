package com.cts.EBanking;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class SmartBankAccount extends BankAccount  {
	
	public SmartBankAccount(int customerId, String name, double balance, List<String> accounts) {
		super(customerId, name, balance, accounts);
	}
	
	
	public double calculateFixedAccount(double amount,int months)
	{
		NumberFormat ft = new DecimalFormat(".00");
		int n = 12;
		if(9999 < amount && amount < 1000001 && 0 < months && months < 121)
		{
			double totalAmount = amount * Math.pow((1 + (0.1/n)), months);
			return Double.parseDouble(ft.format(totalAmount));
		}
		return -1;
	}
	
	public double calculateRecurringAccount(double amount,int months)
	{
		NumberFormat ft = new DecimalFormat(".00");
		if((999 < amount && amount < 50001) && (0 < months && months < 61))
		{
			double totalAmount = (amount * months) + (((amount*months*(months + 1))/24) * (0.07));
			return Double.parseDouble(ft.format(totalAmount));
		}
		return -1;
	}
	
}
