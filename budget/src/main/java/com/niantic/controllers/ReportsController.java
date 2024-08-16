package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Subcategory;
import com.niantic.models.User;
import com.niantic.services.CategoriesDao;
import com.niantic.services.SubcategoryDao;
import com.niantic.services.TransactionDao;
import com.niantic.models.Transaction;
import com.niantic.services.UserDao;
import com.sun.jdi.connect.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ReportsController {
    TransactionDao transactionDao = new TransactionDao();
    UserDao userDao = new UserDao();
    CategoriesDao categoriesDao = new CategoriesDao();
    SubcategoryDao subcategoryDao = new SubcategoryDao();

    @GetMapping("/reports")
        public String getAllReports(Model model)
        {
            ArrayList<Transaction> transactions = transactionDao.getTransactions();

            model.addAttribute("transactions", transactions);

            return "/reports/index";
        }

    @GetMapping("/reports/subcategories")
    public String getAllReportsByCategory(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsOrderByCategory();
        ArrayList<Subcategory> subcategories = subcategoryDao.getAllSubcategories();


        model.addAttribute("transactions", transactions);
        model.addAttribute("subcategories", subcategories);

        return "/reports/subcategories";
    }

    @GetMapping("/reports/year")
    public String getAllReportsOrderByYear(Model model)
    {
        
        ArrayList<Transaction> transactions = transactionDao.getTransactionsOrderByYear();
        ArrayList<Integer> uniqueYears = new ArrayList<>();

        for(var transaction : transactions){
            if(!uniqueYears.contains(transaction.getDate().getYear())){
                uniqueYears.add(transaction.getDate().getYear());
            }
        }
        model.addAttribute("uniqueYears", uniqueYears);
        model.addAttribute("transactions", transactions);

        return "/reports/year";
    }

    @GetMapping("/reports/month")
    public String getAllReportsByMonth(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactionsOrderByMonth();
        ArrayList<Integer> uniqueMonth = new ArrayList<>();

        for(var transaction : transactions){
            if(!uniqueMonth.contains(transaction.getDate().getMonthValue())){
                uniqueMonth.add(transaction.getDate().getMonthValue());
            }
        }
        model.addAttribute("uniqueMonths", uniqueMonth);
        model.addAttribute("transactions", transactions);

        return "/reports/month";
    }

    @GetMapping("/reports/user")
    public String getAllReportsByUser(Model model)
    {
        ArrayList<Transaction> transactions = transactionDao.getTransactions();
        ArrayList<User> users = userDao.getAllUsers();

        model.addAttribute("transactions", transactions);
        model.addAttribute("users", users);

        return "/reports/user";
    }
}
