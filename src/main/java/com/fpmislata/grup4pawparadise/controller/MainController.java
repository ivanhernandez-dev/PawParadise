package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private CategoryService categoryService = new CategoryServiceImpl();
    private final String DEFAULT_LANGUAGE = "es";

    @GetMapping("/{language}")
    public String getAll(Model model, @PathVariable(required = false) String language) {
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("categories", this.categoryService.getChildrenByParentId(null, language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "index";
    }

    @GetMapping("/")
    public String redirectToDefaultLanguage() {
        return "redirect:/" + DEFAULT_LANGUAGE;
    }

    @GetMapping("/{language}/about-us")
    public String aboutUs(Model model, @PathVariable String language) {
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "about-us";
    }

    @GetMapping("/{language}/login")
    public String login(Model model, @PathVariable String language) {
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "login";
    }

    @GetMapping("/{language}/register")
    public String register(Model model, @PathVariable String language) {
        try {
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "register";
    }
}
