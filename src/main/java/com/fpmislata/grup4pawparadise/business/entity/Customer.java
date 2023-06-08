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

    public Customer(int id, String name, String surname, String email, String password, String street, int number,
            int doorNumber, int postalCode) {
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
