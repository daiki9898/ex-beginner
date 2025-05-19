package com.example.ex_beginner.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    @Autowired
    ServletContext application;

    @GetMapping
    public String index() {
        return "exam03";
    }

    @GetMapping("/result")
    public String result() {
        return "exam03-result";
    }

    @PostMapping("/calc-total-price")
    public String calcTotalPrice(int price1, int price2, int price3) {
        int noTaxTotalPrice = price1 + price2 + price3;
        int inTaxTotalPrice = (int) (noTaxTotalPrice * 1.1);
        application.setAttribute("noTaxTotalPrice", noTaxTotalPrice);
        application.setAttribute("inTaxTotalPrice", inTaxTotalPrice);
        return result();
    }
}
