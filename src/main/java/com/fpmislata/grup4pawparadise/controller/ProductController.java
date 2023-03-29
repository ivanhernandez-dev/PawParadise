package com.fpmislata.grup4pawparadise.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.business.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/productos")
public class ProductController {
    
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/{categoryId}")
    public String findByCategoryId(@PathVariable("categoryId") int categoryId, Model model){
        model.addAttribute("products", this.productService.findByCategoryId(categoryId));
        return "products";
    }


}
