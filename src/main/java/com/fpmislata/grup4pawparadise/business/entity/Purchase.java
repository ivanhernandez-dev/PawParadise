package com.fpmislata.grup4pawparadise.business.entity;

import java.util.Date;
import java.util.List;

public class Purchase {
    private final int id;
    private Date date;
    private int status;
    private int idUser;
    private List<ShoppingCart> shoppingCartList;

    public Purchase(int id, Date date, int status, int idUser, List<ShoppingCart> shoppingCartList) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idUser = idUser;
        this.shoppingCartList = shoppingCartList;
    }
}
