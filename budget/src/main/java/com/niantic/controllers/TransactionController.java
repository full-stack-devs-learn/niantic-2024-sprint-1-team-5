package com.niantic.controllers;

import com.niantic.models.*;
import com.niantic.services.*;
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
    @GetMapping("/transactions/add")
    public String addTransactions(Model model)
    {
        ArrayList<Category> categories = new CategoriesDao().getCategories();
        ArrayList<User> users = new UserDao().getAllUsers();
        ArrayList<Vendor> vendors = new VendorDao().getAllVendors();
        ArrayList<Subcategory> subcategories = new SubcategoryDao().getAllSubcategories();
        Transaction transaction = new Transaction();
        model.addAttribute("categories", categories);
        model.addAttribute("users", users);
        model.addAttribute("vendors", vendors);
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("transaction", transaction);
        return "/transactions/add_transaction";
    }
    @PostMapping("/transactions/add")
    public String addTransactions(Model model, @ModelAttribute("transaction") Transaction transaction)
    {
        System.out.println(transaction);
        transactionDao.addTransaction(transaction);
        model.addAttribute("transaction", transaction);
        return "redirect:/transactions";
    }

}
