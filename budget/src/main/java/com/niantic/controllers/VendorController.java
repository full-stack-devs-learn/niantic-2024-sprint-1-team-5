package com.niantic.controllers;

import com.niantic.models.Transaction;
import com.niantic.services.VendorDao;
import com.niantic.models.Vendor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class VendorController {

    VendorDao vendorDao = new VendorDao();

    @GetMapping("/vendors")
    public String getAllVendors(Model model) {

        ArrayList<Vendor> vendors = vendorDao.getAllVendors();

        model.addAttribute("vendors", vendors);


        return "/vendors/index";
    }
}