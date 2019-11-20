package com.company;

public class SalesPerson {

    private String name;
    private String item;
    private int cost;

    public SalesPerson(String name, String item, int cost) {
        this.name = name;
        this.item = item;
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }
}
