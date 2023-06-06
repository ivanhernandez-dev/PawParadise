package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.entity.Customer;
import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.PurchaseService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.PurchaseServiceImpl;
import com.fpmislata.grup4pawparadise.translation.JsonUtil;

import org.springframework.ui.Model;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/{language}/carrito")
@Controller
public class PurchaseController {

    private final JsonUtil jsonUtil = new JsonUtil();
    private final PurchaseService purchaseService = new PurchaseServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private static final Customer CUSTOMER = new Customer(1, "Alma", "López", "alma@gmail.com",
            "alma", "Calle Alta", 1, 1, 46001);

    @PatchMapping("")
    public String setStatus(@PathVariable String language) {
        try {
            purchaseService.updatePurchaseStatus(
                    purchaseService.getByUserIdWhereStatusActive(CUSTOMER.getId(), language).getId(),
                    1, CUSTOMER.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/" + language + "/carrito";
    }

    @GetMapping("")
    public String getByUserIdWhereStatusActive(@PathVariable String language, Model model) {
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("purchase", purchaseService.getByUserIdWhereStatusActive(CUSTOMER.getId(),
                    language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/carrito");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "shopping-cart";
    }
}
