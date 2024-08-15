package com.niantic.controllers;

import com.niantic.services.TransactionDao;
import com.niantic.models.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class TransactionController {
    TransactionDao transactionDao = new TransactionDao();

    @GetMapping("/transactions")
    public String getAllTransactions(Model model)
    {
        ArrayList<Transaction> transactions;

        transactions = transactionDao.getTransactions();

        model.addAttribute("transactions", transactions);

        return "transactions/index";
    }

}
