package com.niantic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.niantic.services.TransactionDao;


@SpringBootApplication
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}

}
