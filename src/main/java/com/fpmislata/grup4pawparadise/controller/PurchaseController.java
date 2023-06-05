package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.PurchaseService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.PurchaseServiceImpl;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/{language}/carrito")
@Controller
public class PurchaseController {

    private PurchaseService purchaseService = new PurchaseServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private static final int USER_ID = 1;

    @PatchMapping("")
    public String setStatus(@PathVariable String language) {
        try {
            purchaseService.updatePurchaseStatus(
                    purchaseService.getByUserIdWhereStatusActive(USER_ID, language).getId(),
                    1, USER_ID);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/" + language + "/carrito";
    }

    @GetMapping("")
    public String getByUserIdWhereStatusActive(@PathVariable String language, Model model) {
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("purchase", purchaseService.getByUserIdWhereStatusActive(USER_ID, language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/carrito");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "shopping-cart";
    }
}
