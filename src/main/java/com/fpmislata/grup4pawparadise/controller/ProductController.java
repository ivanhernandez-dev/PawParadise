package com.fpmislata.grup4pawparadise.controller;


import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("/{language}/productos/{productId}")
    public String getById(@PathVariable("productId") int productId, Model model, @PathVariable String language){
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("product", this.productService.getById(productId, language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/productos/" + productId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "product";
    }

    @GetMapping("/{language}/productos/buscar")
    public String getByName(Model model, @PathVariable String language, HttpServletRequest httpServletRequest){
        try {
            String name = httpServletRequest.getParameter("nombre");
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("products", this.productService.getByName(name, language));
            model.addAttribute("actualCategoryName", name);
            model.addAttribute("language", language);
            model.addAttribute("route", "/productos/buscar");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "category";
    }
}
