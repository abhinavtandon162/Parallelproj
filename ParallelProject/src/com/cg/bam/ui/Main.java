package com.cg.bam.ui;

import java.util.Scanner;

import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountServiceImpl;

public class Main {
	static BankAccountServiceImpl service = new BankAccountServiceImpl();
  
	static Scanner sc = new Scanner(System.in);

	static String name;
	static String mobileNo;
	static int age;
	static double amount;
	static Customer customer;
	public static void main(String args[]) throws BankAccountException{
		

		int ch = 0;
		while(true){
			System.out.println("1.Add Customer Details");
			System.out.println("2.Deposit amount");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Funds Transfer");
			System.out.println("5.Check Customer Balance");
			System.out.println("6.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch(ch){
			case 1 : addCustomer();break;
			case 2 : deposit(); break;					
			case 3 : withdraw(); break;				
			case 4 : fundTransfer();break;
			case 5 : checkBalance(); break;
			case 6 : exit();break;
			default : System.out.println("Invalid input!");
			}

		}

	}
	private static void exit() {
		System.out.println("Thank You!");
		System.exit(0);

	}
	private static int checkBalance() throws BankAccountException {

		System.out.println("Enter the moible id to check balance");
		mobileNo = sc.next();
		if(!service.validateAccount(mobileNo)){
			System.out.println("Mobile Number not found!");
			return 0;
		}


		System.out.println("Current Amount is Rs."+service.checkBalance(mobileNo));
		return 0;

	}
	private static int fundTransfer() throws BankAccountException {
		String mobileNoReciever;
		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();

		System.out.println("Enter the amount you want to transfer : ");
		amount = sc.nextDouble();

		System.out.println("Enter receivers mobile number : ");
		mobileNoReciever = sc.next();
		if(mobileNo.equals(mobileNoReciever)){								
			System.out.println("Both numbers are same!");
			return 0;
		}
		if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
			if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
				service.fundTransfer(mobileNo, mobileNoReciever, amount);
		}

		return 0;


	}
	private static int withdraw() throws BankAccountException {
		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();

		System.out.println("Enter the amount you want to withdraw : ");
		amount = sc.nextDouble();
		if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){
			if(!service.validateAccount(mobileNo))
				return 0;
		}
		service.withdraw(mobileNo, amount);
		return 0;

	}
	private static int deposit() throws BankAccountException {
		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();

		System.out.println("Enter the amount you want to deposit");
		amount = sc.nextDouble();
		if(service.validateMoileNo(mobileNo)&& service.validateAmount(amount)){
			if(!service.validateAccount(mobileNo))
				return 0;
		}
		service.deposit(mobileNo, amount);
		return 0;

	}
	private static int addCustomer() throws BankAccountException {
		customer = new Customer();						

		System.out.println("Enter customer name : ");
		name = sc.next();
		if(!service.validateName(name))
		{
			System.err.println("Invalid Name!");
			return 0;
		}
		System.out.println("Enter mobile no. : ");
		mobileNo = sc.next();
		if(!service.validateMoileNo(mobileNo))
		{
			System.err.println("Invalid Mobile Number");
			return 0;
		}
		else if(service.validateAccount(mobileNo))
		{
			System.err.println("Customer already exist with this number!");
			return 0;
		}
		else
			System.out.println("Enter age : ");
		age = sc.nextInt();
		if(service.validateAge(age))
			System.out.println("Enter initial amount : ");
		amount = sc.nextDouble();
		if(!service.validateAmount(amount))
		{
			System.err.println("Invalid Amount!");
			return 0;
		}
		else{	
			customer.setName(name);
			customer.setMobileNo(mobileNo);
			customer.setAge(age);
			customer.setInitialBalance(amount);

			service.createAccount(customer);

			System.out.println("Customer added successfully");
		}
		return 0;
	}
}
