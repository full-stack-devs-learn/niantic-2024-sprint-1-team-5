package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoriesDao;
import com.niantic.services.TransactionDao;
import com.niantic.models.Transaction;
import com.niantic.services.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ReportsController {
    TransactionDao transactionDao = new TransactionDao();
    UserDao userDao = new UserDao();

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
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByCategory(1,1);

        model.addAttribute("transactions", transactions);

        return "/reports/category";
    }

    @GetMapping("/reports/year")
    public String getAllReportsByYear(Model model)
    {
        return "/reports/year";
    }

    @GetMapping("/reports/{year}")
    public String getAllReportsByYear(Model model, @PathVariable int year, int userId)
    {
        
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByYear(year, userId);

        model.addAttribute("transactions", transactions);

        return "/reports/year";
    }

    @GetMapping("/reports/month")
    public String getAllReportsByMonth(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByMonth(1, 8);

        model.addAttribute("transactions", transactions);

        return "/reports/month";
    }

    @GetMapping("/reports/user")
    public String getAllReportsByUser(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsByUser(1);

        model.addAttribute("transactions", transactions);

        return "/reports/user";
    }
}
