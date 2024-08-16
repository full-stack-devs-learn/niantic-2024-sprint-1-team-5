package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoriesDao;
import com.niantic.services.TransactionDao;
import com.niantic.models.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ReportsController {
    TransactionDao transactionDao = new TransactionDao();

    @GetMapping("/reports")
        public String getAllReports(Model model)
        {
            ArrayList<Transaction> transactions = transactionDao.getTransactions();

            model.addAttribute("transactions", transactions);

            return "/reports/index";
        }

    @GetMapping("/reports/category")
    public String getAllReportsByCategory(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByCategory();

        model.addAttribute("transactions", transactions);

        return "/reports/category";
    }

    @GetMapping("/reports/year")
    public String getAllReportsByYear(Model model)
    {
        return "/reports/year";
    }

    @GetMapping("/reports/{year}")
    public String getAllReportsByYear(Model model, @PathVariable int year)
    {
        
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByYear(year);

        model.addAttribute("transactions", transactions);

        return "/reports/year";
    }

    @GetMapping("/reports/month")
    public String getAllReportsByMonth(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByMonth();

        model.addAttribute("transactions", transactions);

        return "/reports/month";
    }

    @GetMapping("/reports/user")
    public String getAllReportsByUser(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByUser();

        model.addAttribute("transactions", transactions);

        return "/reports/user";
    }
}
