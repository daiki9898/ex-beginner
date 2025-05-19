package com.example.ex_beginner.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
    @Autowired
    HttpSession session;

    @GetMapping
    public String index() {
        return "exam02";
    }

    @GetMapping("/result")
    public String result() {
        return "exam02-result";
    }

    @GetMapping("/result2")
    public String result2() {
        return "exam02-result2";
    }

    @PostMapping("/sum")
    public String sum(int num1, int num2) {
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("answer", (num1 + num2));
        return result();
    }
}
