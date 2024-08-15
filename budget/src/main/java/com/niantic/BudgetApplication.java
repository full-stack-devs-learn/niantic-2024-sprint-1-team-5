package com.niantic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.niantic.services.TransactionDao;


@SpringBootApplication
public class BudgetApplication {

	public static void main(String[] args) {

		TransactionDao transactionDao = new TransactionDao();

		var transactions = transactionDao.getTransactionByUser(1);

		for(var transaction : transactions){
			System.out.println(transaction);
		}




		SpringApplication.run(BudgetApplication.class, args);
	}

}
