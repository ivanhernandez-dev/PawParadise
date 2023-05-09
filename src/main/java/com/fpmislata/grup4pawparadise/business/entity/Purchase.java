package com.fpmislata.grup4pawparadise.business.entity;

import java.util.Date;
import java.util.List;

public class Purchase {
    private Date date;
    private int status;
    private int idUser;
    private List<ShoppingCart> shoppingCartList;

    public Purchase(Date date, int status, int idUser, List<ShoppingCart> shoppingCartList) {
        this.date = date;
        this.status = status;
        this.idUser = idUser;
        this.shoppingCartList = shoppingCartList;
    }
}
