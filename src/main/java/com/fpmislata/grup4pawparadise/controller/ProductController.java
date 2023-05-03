package com.fpmislata.grup4pawparadise.controller;


import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.business.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    
    private ProductService productService = new ProductServiceImpl();
    @GetMapping("/{language}/productos/{productId}")
    public String getById(@PathVariable("productId") int productId, Model model, @PathVariable String language){
        try {
            model.addAttribute("products", this.productService.getById(productId, language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "product";
    }
}
