package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Purchase {

    private final int id;
    private Date date;
    private int status;
    private int idUser;
    private List<PurchaseLine> purchaseLineList;
    private BigDecimal totalPrice;

    public Purchase(int id, Date date, int status, int idUser, List<PurchaseLine> purchaseLineList) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idUser = idUser;
        this.purchaseLineList = purchaseLineList;
        this.totalPrice = new BigDecimal("0");
        for (PurchaseLine purchaseLine : purchaseLineList) {
            this.totalPrice = this.totalPrice.add(purchaseLine.getTotalPrice());
        }
    }

    public Purchase(int id, Date date, int status, int idUser) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }

    public int getIdUser() {
        return idUser;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PurchaseLine> getPurchaseLineList() {
        return purchaseLineList;
    }

    public void setPurchaseLineList(List<PurchaseLine> purchaseLineList) {
        this.purchaseLineList = purchaseLineList;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                ", idUser=" + idUser +
                ", shoppingCartList=" + purchaseLineList +
                '}';
    }
}
