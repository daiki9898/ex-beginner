package com.example.ex_beginner.controller;

import com.example.ex_beginner.domain.Item;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final HttpSession session;
    private final ServletContext application;


    @GetMapping
    public String index(Model model) {
        // 商品一覧がない場合、空のリストを入れる
        if (application.getAttribute("itemList") == null) {
            Item item1 = new Item("手帳ノート", 1000);
            Item item2 = new Item("文房具セット", 1500);
            Item item3 = new Item("ファイル", 2000);
            List<Item> itemList = new LinkedList<Item>(List.of(item1, item2, item3));

            application.setAttribute("itemList", itemList);
        }

        List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
        Integer totalPrice = 0;

        // ショッピングカートの商品一覧が存在しない場合、空のリストを入れる
        if (cartItemList == null) {
            session.setAttribute("cartItemList", new LinkedList<Item>());
        } else {
            // 合計金額を算出
            for (Item item : cartItemList) {
                totalPrice += item.getPrice();
            }
        }

        model.addAttribute("totalPrice", totalPrice);
        return "item-and-cart";
    }

    @PostMapping("/add-to-cart")
    public String inCart(String index) {
        System.out.println(index);
        List<Item> itemList = (List<Item>) application.getAttribute("itemList");
        List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
        // 商品を追加
        cartItemList.add(itemList.get(Integer.parseInt(index)));
        return "redirect:/shopping";
    }

    @PostMapping("/delete-from-cart")
    public String delete(String index) {
        List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
        // 商品を削除
        cartItemList.remove(Integer.parseInt(index));
        return "redirect:/shopping";
    }
}
