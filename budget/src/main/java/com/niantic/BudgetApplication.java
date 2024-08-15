package com.niantic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.niantic.services.TransactionDao;


@SpringBootApplication
public class BudgetApplication {

	public static void main(String[] args) {

		TransactionDao transactionDao = new TransactionDao();

		var transactions = transactionDao.getTransactionById(3);

		System.out.println(transactions);




		SpringApplication.run(BudgetApplication.class, args);
	}

}
