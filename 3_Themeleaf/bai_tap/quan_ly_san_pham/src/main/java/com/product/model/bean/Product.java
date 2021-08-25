package com.product.model.bean;

public class Product {
    private int id;
    private String name;
    private double price;
    private String des;
    private String madeBy;

    public Product(int id, String name, double price, String des, String madeBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.madeBy = madeBy;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }
}
