package com.jsp.PersonBank;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		
		EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("aniket");
		EntityManager eManager = eMFactory.createEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		
		
		
		Person person = new Person();
		person.setName("sujit");
		person.setCno(862930002);
		person.setEmail("sujit@gmail.com");
		
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setBank_name("SBI");
		bankAccount1.setAcc_no(235738568);
		bankAccount1.setIfsc("SBI0986");
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setBank_name("SBI");
		bankAccount2.setAcc_no(211738568);
		bankAccount2.setIfsc("SBI0987");
		
		BankAccount bankAccount3 = new BankAccount();
		bankAccount3.setBank_name("SBI");
		bankAccount3.setAcc_no(235008568);
		bankAccount3.setIfsc("SBI0988");
		
		List<BankAccount> bankAccount = new ArrayList();
		bankAccount.add(bankAccount1);
		bankAccount.add(bankAccount2);
		bankAccount.add(bankAccount3);
		
		person.setBank_account(bankAccount);
		
		eTransaction.begin();
		eManager.persist(person);
		eManager.persist(bankAccount1);
		eManager.persist(bankAccount2);
		eManager.persist(bankAccount3);
		eTransaction.commit();
		
		System.out.println("all good");
	}
}
