package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.ProductServiceImpl;
import com.fpmislata.grup4pawparadise.translation.JsonUtil;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CategoryController {
    
    private JsonUtil jsonUtil = new JsonUtil();
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/{language}/categorias/{categoryId}")
    public String getByCategoryIdWithSuccessors(@PathVariable("categoryId") int categoryId, Model model, @PathVariable String language){
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("categories", this.categoryService.getChildrenByParentId(categoryId, language));
            model.addAttribute("products", this.productService.getByCategoryIdWithSuccessors(categoryId, language));
            model.addAttribute("actualCategoryName", this.categoryService.getById(categoryId, language).getName());
            model.addAttribute("language", language);
            model.addAttribute("route", "/categorias/" + categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "category";
    }
}
