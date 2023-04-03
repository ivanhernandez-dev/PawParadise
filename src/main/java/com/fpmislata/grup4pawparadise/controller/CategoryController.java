package com.fpmislata.grup4pawparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;


@Controller
public class CategoryController {

    private CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("categories", this.categoryService.getAll());
        return "categories";
    }
    
}
