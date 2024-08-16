package com.niantic.controllers;

import com.niantic.models.Transaction;
import com.niantic.services.UserDao;
import com.niantic.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {

    UserDao userDao = new UserDao();

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        ArrayList<User> users = userDao.getAllUsers();

        model.addAttribute("users", users);


        return "/users/index";
    }
}