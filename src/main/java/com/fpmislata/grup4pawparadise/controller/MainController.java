package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.business.service.impl.CategoryServiceImpl;
import com.fpmislata.grup4pawparadise.translation.JsonUtil;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final JsonUtil jsonUtil = new JsonUtil();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @GetMapping("/{language}")
    public String getAll(Model model, @PathVariable String language) {
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("categories", this.categoryService.getChildrenByParentId(null, language));
            model.addAttribute("language", language);
            model.addAttribute("route", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "index";
    }

    @GetMapping("/")
    public String redirectToDefaultLanguage() {
        String DEFAULT_LANGUAGE = "es";
        return "redirect:/" + DEFAULT_LANGUAGE;
    }

    @GetMapping("/{language}/about-us")
    public String aboutUs(Model model, @PathVariable String language) {
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/about-us");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "about-us";
    }

    @GetMapping("/{language}/login")
    public String login(Model model, @PathVariable String language) {
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/login");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "login";
    }

    @GetMapping("/{language}/register")
    public String register(Model model, @PathVariable String language) {
        try {
            JSONObject jsonData = jsonUtil.readJsonData(language);

            model.addAttribute("jsonData", jsonData);
            model.addAttribute("allCategories", this.categoryService.getAll(language));
            model.addAttribute("language", language);
            model.addAttribute("route", "/register");
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "register";
    }
}
