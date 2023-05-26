package com.fpmislata.grup4pawparadise.controller;

import com.fpmislata.grup4pawparadise.business.service.PurchaseLineService;
import com.fpmislata.grup4pawparadise.business.service.PurchaseService;
import com.fpmislata.grup4pawparadise.business.service.impl.PurchaseLineServiceImpl;
import com.fpmislata.grup4pawparadise.business.service.impl.PurchaseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/{language}/carrito/producto/{productId}")
@Controller
public class PurchaseLineController {

    private PurchaseLineService purchaseLineService = new PurchaseLineServiceImpl();
    private PurchaseService purchaseService = new PurchaseServiceImpl();

    private static final int USER_ID = 1;
    @PostMapping("")
    public String add(@PathVariable String language, @PathVariable int productId, @RequestParam int quantity){
        try {
            purchaseLineService.insert(purchaseService.getByUserIdWhereStatusActive(USER_ID, language).getId(),
                    productId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/"+ language + "/productos/" + productId;
    }

    @DeleteMapping("")
    public String delete(@PathVariable String language, @PathVariable int productId){
        try {
            purchaseLineService.delete(purchaseService.getByUserIdWhereStatusActive(USER_ID, language).getId(), productId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/" + language + "/carrito";
    }

    @PatchMapping("")
    public String update(@PathVariable String language, @PathVariable int productId, @RequestParam int quantity){
        try {
            purchaseLineService.update(purchaseService.getByUserIdWhereStatusActive(USER_ID, language).getId(), productId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/" + language + "/carrito";
    }
}
