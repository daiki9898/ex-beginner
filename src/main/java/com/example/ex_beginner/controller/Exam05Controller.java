package com.example.ex_beginner.controller;

import com.example.ex_beginner.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam05")
@RequiredArgsConstructor
public class Exam05Controller {
    private final MemberRepository memberRepository;

    @GetMapping
    public String index() {
        return "exam05";
    }

    @GetMapping("/result")
    public String result() {
        return "exam05-result";
    }

    @PostMapping("search-by-name")
    public String searchByName(String name, Model model) {
        List<String> memberList = new ArrayList<>();
        memberRepository.findByName(name).forEach(member -> {
            memberList.add(member.getName());
        });

        model.addAttribute("memberList", memberList);
        return result();
    }
}
