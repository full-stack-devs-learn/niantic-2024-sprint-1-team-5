package com.niantic.controllers;

import com.niantic.models.Transaction;
import com.niantic.services.CategoriesDao;
import com.niantic.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CategoriesController {

    CategoriesDao categoriesDao = new CategoriesDao();

    @GetMapping("/categories")
    public String getAllCategories(Model model){

        ArrayList<Category> categories = categoriesDao.getCategories();

        model.addAttribute("categories", categories);


        return "/categories/index";
    }
    @GetMapping("/categories/add")
    public String addCategories()
    {
        return "/categories/add_category";
    }
    @PostMapping("/categories/add")
    public String addCategories(Model model, @ModelAttribute("category") Category category)
    {
        categoriesDao.addCategory(category);
        model.addAttribute("category", category);
        return "redirect:/categories";
    }
}
