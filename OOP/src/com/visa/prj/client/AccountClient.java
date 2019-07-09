package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		Account first = new Account("SBI001");
		Account second = new Account("SBI002");
		
		first.deposit(5000); //deposit(first,5000)
		second.deposit(2500); //deposit(second,2500)
		
		System.out.println("first account");
		System.out.println("Balance : "+ first.getBalance()); 
		
		System.out.println("second account");
		System.out.println("Balance : "+ second.getBalance());
		
		Account rahul = new Account("SBI100");
		Account swetha = new Account("SBI100");
		
		Account ref = rahul;
		
		if(ref == rahul)
				System.out.println("ref and rahul points to same location");
		
		if(rahul.equals(swetha))
				System.out.println("Same content!");
		
		System.out.println(swetha.getCountButWrong()); //goes under the wrong impression that swetha has 4 accounts
		System.out.println(Account.getCount());
		

	}

	

}
