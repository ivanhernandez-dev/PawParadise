package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CategoryController {

    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/{language}/categorias/{categoryId}")
    public String findByCategoryIdWithSuccessors(@PathVariable("categoryId") int categoryId, Model model, @PathVariable String language){
        try {
            System.out.println(this.productService.findByCategoryIdWithSuccessors(categoryId, language));
            model.addAttribute("categories", this.categoryService.getChildrenByParentId(categoryId, language));
            model.addAttribute("products", this.productService.findByCategoryIdWithSuccessors(categoryId, language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "category";
    }
}
