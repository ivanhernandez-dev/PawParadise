package com.fpmislata.grup4pawparadise.business.entity;

public class Customer {

    public final int id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String street;
    public int number;
    public int doorNumber;
    public int postalCode;

    public Customer(int id, String name, String surname, String email, String password, String street, int number, int doorNumber, int postalCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.street = street;
        this.number = number;
        this.doorNumber = doorNumber;
        this.postalCode = postalCode;
    }
}
